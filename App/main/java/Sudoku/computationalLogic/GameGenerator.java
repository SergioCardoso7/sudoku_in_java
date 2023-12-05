package Sudoku.computationalLogic;

import Sudoku.problemDomain.Coordinates;
import Sudoku.problemDomain.SudokuGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Sudoku.problemDomain.SudokuGame.GRID_BOUNDARY;

public class GameGenerator {

    public static int[][] getNewGameGrid() {
        return unsolveGame(getSolvedGame());
    }

    //change this to a graph coloring problem algorithm
    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        final int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        for (int value = 1; value <= GRID_BOUNDARY; value++) {
            int allocation = 0;
            int interrupt = 0;
            List<Coordinates> allocTracker = new ArrayList<>();

            int attempts = 0;

            while (allocation < GRID_BOUNDARY) {
                if (interrupt > 200) {
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });
                    interrupt = 0;
                    allocation = 0;
                    allocTracker.clear();
                    attempts++;

                    if (attempts > 500) {
                        clearArray(newGrid);
                        attempts = 0;
                        value = 1;
                    }

                }
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                if(newGrid[xCoordinate][yCoordinate] == 0){
                    newGrid[xCoordinate][yCoordinate] = value;

                    if(GameLogic.sudokuIsInvalid(newGrid)){
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    }else {
                        allocTracker.add(new Coordinates(xCoordinate,yCoordinate));
                        allocation++;
                    }
                }
            }
        }

        return newGrid;
    }

    public static void clearArray(int[][] grid){
        for (int i = 0; i < GRID_BOUNDARY; i++) {
            for (int j = 0; j < GRID_BOUNDARY; j++) {
                grid[i][j] = 0;
            }
        }
    }

    private static int[][] unsolveGame(int[][] solvedGame){
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while (solvable == false){
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);

            int index = 0;

            while(index < 40){
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                if(solvableArray[xCoordinate][yCoordinate] != 0){
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }
            }

            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray,toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
        }

        return solvableArray;
    }

}
