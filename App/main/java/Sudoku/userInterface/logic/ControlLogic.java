package Sudoku.userInterface.logic;

import Sudoku.Constants.GameState;
import Sudoku.Constants.Messages;
import Sudoku.computationalLogic.GameLogic;
import Sudoku.problemDomain.IStorage;
import Sudoku.problemDomain.SudokuGame;
import Sudoku.userInterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;

    private IUserInterfaceContract.View view;

    //when dealing with a controller/presenter communicate with the backend/frontend through interfaces
    //solid principles
    //helps design the application upfront without worrying about the implementation
    //if the storage implementation or another implementation needs to change, the change can be done easily
    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(GameLogic.checkForCompletion(newGridState),newGridState);

            storage.updateGameData(gameData);

            view.updateSquare(x,y,input);
            if(gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        }catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogCLick() {
        try {
            storage.updateGameData(GameLogic.getNewGame());

            view.updateBoard(storage.getGameData());
        }catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);

        }
    }
}
