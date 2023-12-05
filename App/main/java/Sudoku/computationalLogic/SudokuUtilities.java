package Sudoku.computationalLogic;

import Sudoku.problemDomain.SudokuGame;

public class SudokuUtilities {

    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray){
        for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY ; yIndex++) {
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }


    public static int[][] copyToNewArray(int[][] gridState){
        int[][] newArray = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];
        for (int i = 0; i < SudokuGame.GRID_BOUNDARY ; i++) {
            for (int j = 0; j < SudokuGame.GRID_BOUNDARY; j++) {
                newArray[i][j] = gridState[i][j];
            }
        }
        return newArray;
    }
}
