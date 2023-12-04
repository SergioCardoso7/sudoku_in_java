package Sudoku.userInterface;

import Sudoku.problemDomain.SudokuGame;

public interface IUserInterfaceContract {
    //using the parent interface as a kind of namespace,
    // a way of differentiating interfaces
    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogCLick();
    }
    //event listener will be sort of a controller or presenter
    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
