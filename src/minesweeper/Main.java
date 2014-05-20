package minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import minesweeper.models.Cell;
import minesweeper.models.CellType;
import minesweeper.models.MineField;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MinesweeperApplication().start(primaryStage, getClass().getResource("views/welcomeScreen.fxml"));
    }

    public static void main(String[] args) {
        MineField mf = new MineField(9, 9, 10);
        // Cell cell = new Cell(mf, 3, 2, CellType.FLAG);
        // System.out.println(cell.getRow());

        launch(args);
    }
}
