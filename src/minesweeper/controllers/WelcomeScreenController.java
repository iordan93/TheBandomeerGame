package minesweeper.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import minesweeper.MinesweeperApplication;

import minesweeper.Settings;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

public class WelcomeScreenController {
    public Button newGame;
    public Button loadLastGame;
    public Button instructions;
    public Button about;

    public void startNewGame(ActionEvent action) throws Exception {
        Stage stage = new Stage();
        ((Node) action.getSource()).getScene().getWindow().hide();
        Parent root = new MinesweeperApplication().start(stage, getClass().getResource("../views/mainWindow.fxml"));
        new MainGameController().initialize();
    }

    public void showInstructions(ActionEvent action) {
        Stage newStage = new Stage();
        VBox comp = new VBox();
        Text heading = new Text("Instructions");
        heading.setStyle("-fx-font-size: 40px;");
        heading.setTextAlignment(TextAlignment.CENTER);
        TextArea instructions = new TextArea("How to play\n" +
                "The rules in Minesweeper are simple:\n" +
                "•\tUncover a mine, and the game ends.\n" +
                "•\tUncover an empty square, and you keep playing.\n" +
                "•\tUncover a number, and it tells you how many mines lay hidden in the eight surrounding squares—information you use to deduce which nearby squares are safe to click.\n" +
                "Hints and tips\n" +
                "Mark the mines. If you suspect a square conceals a mine, right-click it. This puts a flag on the square. (If you're not sure, right-click again to make it a question mark.)\n" +
                "Study the patterns. If three squares in a row display 2-3-2, then you know three mines are probably lined up beside that row. If a square says 8, every surrounding square is mined.\n" +
                "Explore the unexplored. Not sure where to click next? Try clearing some unexplored territory. You're better off clicking in the middle of unmarked squares than in an area you suspect is mined.\n" +
                "\n");
        instructions.setEditable(false);
        instructions.setMinHeight(320);
        instructions.setStyle("-fx-text-fill: rgba(0, 0, 0, 0.8); \n" +
                "-fx-font-weight: bold; \n" +
                "-fx-font-size: 20px; \n" +
                "-fx-padding: 30px");
        comp.getChildren().add(heading);
        comp.getChildren().add(instructions);

        Scene stageScene = new Scene(comp);
        newStage.setScene(stageScene);
        newStage.show();
    }

    public void showAboutScreen(ActionEvent action) {
        Stage newStage = new Stage();
        VBox comp = new VBox();
        Label about = new Label("TEAM BANDOMEER © 2014\n" +
                "\n" +
                "Lead Programmer\n" +
                "YORDAN DARAKCHIEV\n" +
                "\n" +
                "Additional Programming\n" +
                "VELIKO DIMOV\n" +
                "DIMITAR DIMITROV\n" +
                "MIHAIL YOTOV\n" +
                "\n" +
                "SOFTUNI MAY 2014");
        about.setStyle("-fx-text-fill: rgba(0, 0, 0, 0.8); \n" +
                "-fx-font-weight: bold; \n" +
                "-fx-font-size: 20px; \n" +
                "-fx-padding: 50px");
        comp.getChildren().add(about);

        Scene stageScene = new Scene(comp);
        newStage.setScene(stageScene);
        newStage.show();
    }
}
