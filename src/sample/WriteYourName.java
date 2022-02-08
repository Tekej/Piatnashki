package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WriteYourName {
    public Scene scene;

    public WriteYourName() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/Fxmls/WriteYourName.fxml"));
        Parent parent = fxml.load();
        scene = new Scene(parent);

    }

    public Scene getScene() {
        return scene;
    }
}
