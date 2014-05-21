package minesweeper.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import minesweeper.Settings;
import minesweeper.models.MineField;


public class MainGameController {

    @FXML
    public GridPane mainContent;

    @FXML
    public void initialize() {
        MineField field = new MineField(Settings.INITIAL_ROWS, Settings.INITIAL_COLS, Settings.INITIAL_MINES);
        Button[][] buttons = new Button[Settings.INITIAL_ROWS][Settings.INITIAL_COLS];
//        for (int i = 0; i < buttons.length; i++) {
//            for (int j = 0; j < buttons[0].length; j++) {
//                mainContent.getChildren().add(buttons[i][j]);
//            }
//        }
    }
}
