package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


public class MainMenuController {
    @FXML
    private Button exit;

    @FXML
    public void windowPassageSizeSelector() throws IOException {
        Main.stage.setScene(new SizeSelector().scene);
        Game.endGame = false;
        Zegar.time = 0;
    }
    @FXML
    public void windowPassageHighScores() throws IOException {
        Main.stage.setScene(new HighScores().scene);

    }
    @FXML
    public void exit() throws IOException {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}
