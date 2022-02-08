package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MainMenu {
    public Scene scene;
    public MainMenu() throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Fxmls/MainMenu.fxml")).load();
        scene=new Scene(root);
    }
    public Scene getScene() {
        return scene;
    }
}
