package Sudoku.problemDomain;

import Sudoku.computationalLogic.SudokuUtilities;
import Sudoku.Constants.GameState;

import java.io.Serializable;

public class SudokuGame implements Serializable {


    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(GameState gameState, int[][] gridState){
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }
    // we will return a copy of gridState
    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
