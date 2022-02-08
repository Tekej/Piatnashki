package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HighScores {
    public Scene scene;

    public HighScores() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/Fxmls/HighScores.fxml"));
        Parent parent = fxml.load();
        scene = new Scene(parent);

    }

    public Scene getScene() {
        return scene;
    }
}
