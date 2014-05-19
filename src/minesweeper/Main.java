package minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MinesweeperApplication().start(primaryStage, getClass().getResource("views/welcomeScreen.fxml"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
