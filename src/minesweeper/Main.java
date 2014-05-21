package minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import minesweeper.models.Cell;
import minesweeper.models.CellType;
import minesweeper.models.MineField;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MinesweeperApplication().start(primaryStage, getClass().getResource("views/welcomeScreen.fxml"));
    }

    public static void main(String[] args) {
        MineField field = new MineField(9, 9, 10, new Random(10));
        field.placeMines(0, 0);
        field.getCellAt(3, 5).visit();
        field.getCellAt(0, 0).visit();
        field.getCellAt(0, 1).visit();
        field.getCellAt(0, 3).visit();
        field.getCellAt(3, 0).visit();
        field.getCellAt(2, 2).visit();

        field.getCellAt(0, 2).flag();
        field.getCellAt(0, 6).flag();
        field.getCellAt(0, 7).flag();
        field.getCellAt(1, 0).placeQuestionMark();
        field.getCellAt(0, 2).placeQuestionMark();
        field.getCellAt(0, 6).placeQuestionMark();
        System.out.println(field);
        System.out.println(field.getRemainingFieldsCount());
        launch(args);
    }
}
