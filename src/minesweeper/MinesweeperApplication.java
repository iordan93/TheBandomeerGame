package minesweeper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;


public class MinesweeperApplication {
    public void start(Stage primaryStage, URL fxmlResource) throws Exception {
        Font.loadFont(getClass().getResource("res/fonts/segoeui.ttf").toExternalForm(), 10);

        Parent root = FXMLLoader.load(fxmlResource);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("res/images/icon.png")));
        primaryStage.setTitle(Settings.GAME_NAME);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
