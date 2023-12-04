package Sudoku.ComputationalLogic;

public class SudokuUtilities {


    public static int[][] copyToNewArray(int[][] gridState){
        int[][] newArray = new int[gridState.length][gridState[0].length];
        for (int i = 0; i < gridState.length ; i++) {
            for (int j = 0; j < gridState[0].length; j++) {
                newArray[i][j] = gridState[i][j];
            }
        }
        return newArray;
    }
}
