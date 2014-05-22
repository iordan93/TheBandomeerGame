package minesweeper.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import minesweeper.Settings;
import minesweeper.models.Cell;
import minesweeper.models.MineField;

import java.io.InputStream;
import java.util.Random;


public class MainGameController {

    @FXML
    public GridPane mainContent;

    MineField field;
    Button[][] buttons;

    @FXML
    public void initialize() {
        field = new MineField(Settings.INITIAL_ROWS, Settings.INITIAL_COLS, Settings.INITIAL_MINES, new Random(10));
        field.placeMines(0, 0);
        buttons = new Button[Settings.INITIAL_ROWS][Settings.INITIAL_COLS];
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                CoordsButton currentButton = new CoordsButton();
                currentButton.setRow(i);
                currentButton.setCol(j);

                currentButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        CoordsButton btn = (CoordsButton) event.getTarget();
                        if (event.getButton() == MouseButton.PRIMARY) {
                            field.getCellAt(btn.getRow(), btn.getCol()).visit();
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            Cell currentCell = field.getCellAt(btn.getRow(), btn.getCol());
                            if (currentCell.isFlagged()) {
                                currentCell.toggleQuestionMark();
                            } else if (currentCell.isQuestionMark()) {
                                currentCell.toggleQuestionMark();
                            } else {
                                currentCell.flag();
                            }
                        }

                        updateField();
                    }
                });

                Image currentImage = new Image(getClass().getResourceAsStream("../res/images/sqt0.gif"));
                currentButton.setGraphic(new ImageView(currentImage));
                buttons[i][j] = currentButton;
                mainContent.add(buttons[i][j], j, i);
            }
        }
    }

    private void updateField() {
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                Cell currentCell = field.getCellAt(i, j);
                buttons[i][j].setGraphic(new ImageView(new Image(getImageString(currentCell))));
            }
        }
    }

    private InputStream getImageString(Cell currentCell) {
        switch (currentCell.getType()) {
            case UNOPENED:
                return getClass().getResourceAsStream("../res/images/sqt0.gif");
            case NUMBER:
                switch (currentCell.getContent()) {
                    case 0:
                        return getClass().getResourceAsStream("../res/images/sq0.gif");
                    case 1:
                        return getClass().getResourceAsStream("../res/images/sq1.gif");
                    case 2:
                        return getClass().getResourceAsStream("../res/images/sq2.gif");
                    case 3:
                        return getClass().getResourceAsStream("../res/images/sq3.gif");
                    case 4:
                        return getClass().getResourceAsStream("../res/images/sq4.gif");
                    case 5:
                        return getClass().getResourceAsStream("../res/images/sq5.gif");
                    case 6:
                        return getClass().getResourceAsStream("../res/images/sq6.gif");
                    case 7:
                        return getClass().getResourceAsStream("../res/images/sq7.gif");
                    case 8:
                        return getClass().getResourceAsStream("../res/images/sq8.gif");
                }
                break;
            case MINE:
                return getClass().getResourceAsStream("../res/images/sqt0.gif");
            case FLAGGED_MINE:
                return getClass().getResourceAsStream("../res/images/sqt1.gif");
            case HIT_MINE:
                return getClass().getResourceAsStream("../res/images/mine.gif");
            case FLAG:
                return getClass().getResourceAsStream("../res/images/sqt1.gif");
            case QUESTION_MARK:
                return getClass().getResourceAsStream("../res/images/sqt2.gif");
        }

        // This should never happen
        throw new IllegalArgumentException("The cell type is not valid.");
    }
}
