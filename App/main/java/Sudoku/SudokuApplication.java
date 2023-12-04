package Sudoku;

import Sudoku.ComputationalLogic.SudokuBuildLogic;
import Sudoku.userInterface.IUserInterfaceContract;
import Sudoku.userInterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws Exception{
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }


        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample-fxml"));
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(new Scene(root, 300,275));
        primaryStage.show();

         */
    }

    public static void main(String[] args) {
        launch(args);

    }
}
