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
        launch(args);
    }
}
