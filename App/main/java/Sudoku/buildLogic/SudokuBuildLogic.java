package Sudoku.buildLogic;

import Sudoku.computationalLogic.GameLogic;
import Sudoku.persistence.LocalStorageImpl;
import Sudoku.problemDomain.IStorage;
import Sudoku.problemDomain.SudokuGame;
import Sudoku.userInterface.IUserInterfaceContract;
import Sudoku.userInterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {


    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();


        try {
            initialState = storage.getGameData();
        } catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }



}
