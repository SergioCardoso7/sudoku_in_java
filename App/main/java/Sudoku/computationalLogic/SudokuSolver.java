package Sudoku.computationalLogic;

import Sudoku.problemDomain.Coordinates;

import static Sudoku.problemDomain.SudokuGame.GRID_BOUNDARY;

public class SudokuSolver {

    //algorithm used : simple solving algorithm, cornell university website

    public static boolean puzzleIsSolvable(int[][] puzzle) {

        Coordinates[] emptyCells = typeWritterEnumerate(puzzle);

        int index = 0;
        int input;

        while (index < 10) {
            Coordinates current = emptyCells[index];
            input = 1;

            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;

                if (GameLogic.sudokuIsInvalid(puzzle)) {
                    if (index == 0 && input == GRID_BOUNDARY) {
                        return false;
                    } else if (input == GRID_BOUNDARY) {
                        index--;
                    }
                    input++;
                }else {
                    index++;

                    if(index == 39) return true;

                    input = 10;

                }
            }
        }
        return false;
    }

    // transforming a 2d array into a single dimmension array
    private static Coordinates[] typeWritterEnumerate(int[][] puzzle) {
        Coordinates[] emptyCells = new Coordinates[40];
        int iterator = 0;
        for (int x = 0; x < GRID_BOUNDARY; x++) {
            for (int y = 0; y < GRID_BOUNDARY; y++) {
                if (puzzle[x][y] == 0) {
                    emptyCells[iterator] = new Coordinates(x, y);
                    if (iterator == 39) return emptyCells;
                    iterator++;
                }
            }

        }
        return emptyCells;
    }

}
