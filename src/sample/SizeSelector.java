package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SizeSelector {
    public Scene scene;
    public SizeSelector() throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Fxmls/SizeSelector.fxml")).load();
        scene=new Scene(root);
    }
   public Scene getScene() {
        return scene;
    }
}
