package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class GameWindow {
    public Scene scene;
    public GameWindow(Image image, int width, int height) throws IOException{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Fxmls/GameWindow.fxml"));
        Parent parent = fxml.load();
        GameWindowController gwc = fxml.getController();
        gwc.setGame(new Game(image , width , height));
        scene = new Scene(parent);
    }
}
