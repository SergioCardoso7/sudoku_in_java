package Sudoku.userInterface;

import Sudoku.problemDomain.Coordinates;
import Sudoku.problemDomain.SudokuGame;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;

public class UserInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent> {


    private final Stage stage;
    private final Group root; //somewhat like a div

    //to keep track of the 81 different text fields
    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;
    // will interpret the events and pass messages between the view and the backend

    // because it has a single screen, we are including styling info in the user interface
    // if it has multiple UI screens the info would be in a separate file
    private static final double WINDOW_Y = 732;
    private static final double WINDOW_X = 668;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);
    private static final String SUDOKU = "Sudoku";
    private IUserInterfaceContract.EventListener listener;

    public UserInterfaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    private void initializeUserInterface() {
        drawBackground(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();
    }

    private void drawTextFields(Group root) {
        final int xOrigin = 50;
        final int yOrigin = 50;

        final int xAndYDelta = 64;
        for (int xIndex = 0; xIndex < 9; xIndex++) {
            for (int yIndex = 0; yIndex < 9; yIndex++) {
                int x = xOrigin + xIndex * xAndYDelta;
                int y = yOrigin + yIndex * xAndYDelta;

                SudokuTextField tile = new SudokuTextField(xIndex,yIndex);

                styleSudokuTile(tile,x,y);
                // this class implements EventHandler
                tile.setOnKeyPressed(this);

                textFieldCoordinates.put(new Coordinates(xIndex,yIndex),tile);

                root.getChildren().add(tile);
            }

        }

    }

    private void styleSudokuTile(SudokuTextField tile, double x, double y) {
        Font numberFont = new Font(32);

        tile.setFont(numberFont);
        tile.setAlignment(Pos.CENTER);

        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setPrefHeight(64);
        tile.setPrefWidth(64);

        tile.setBackground(Background.EMPTY);
    }

    private void drawGridLines(Group root) {
        int xAndY = 114;
        int index = 0;
        while (index < 8) {
            int thickness;
            if (index == 2 || index == 5) {
                thickness = 3;
            } else {
                thickness = 2;
            }
            Rectangle verticalLine = getLine(xAndY + 64 * index, BOARD_PADDING, BOARD_X_AND_y, thickness);
            Rectangle horizontalLine = getLine(BOARD_PADDING, xAndY + 64 * index, thickness, BOARD_X_AND_y);
            root.getChildren().addAll(verticalLine, horizontalLine);
            index++;
        }
    }

    private Rectangle getLine(double x, double y, double height, double width) {
        Rectangle line = new Rectangle();
        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);

        line.setFill(Color.BLACK);
        return line;
    }

    private void drawSudokuBoard(Group root) {

    }

    private void drawTitle(Group root) {
    }

    private void drawBackground(Group root) {
    }

    @Override
    public void setListener(IUserInterfaceContract.EventListener listener) {
        this.listener = listener;
    }

    @Override
    public void updateSquare(int x, int y, int input) {

    }

    @Override
    public void updateBoard(SudokuGame game) {

    }

    @Override
    public void showDialog(String message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }

}