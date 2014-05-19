package minesweeper.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import minesweeper.MinesweeperApplication;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WelcomeScreenController {
    public Button newGame;
    public Button loadLastGame;
    public Button instructions;
    public Button about;

    public void startNewGame(ActionEvent action) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../views/mainWindow.fxml"));
//        Stage stage = new Stage();
//        stage.setTitle(Settings.GAME_NAME);
//        stage.setResizable(false);
//        stage.setScene(new Scene(root));
//        stage.show();
        new MinesweeperApplication().start(new Stage(),getClass().getResource("../views/mainWindow.fxml"));
        ((Node)action.getSource()).getScene().getWindow().hide();
    }

    public void loadLastGame(ActionEvent action) {
        // TODO: Load last game from file
        throw new NotImplementedException();

    }

    public void showInstructions(ActionEvent action) {
        // TODO: Show instructions screen
        throw new NotImplementedException();

    }

    public void showAboutScreen(ActionEvent action) {
        // TODO: Show about screen
        throw new NotImplementedException();
    }
}
