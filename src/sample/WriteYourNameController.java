package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteYourNameController {
    @FXML
    private TextField nameField;
    @FXML
    public void windowPassage() throws IOException {
        FileOutputStream fs = new FileOutputStream(new File("HighScore.txt"), true);
        String s = nameField.getText() + " " + SizeSelectorController.width + "x" + SizeSelectorController.height + " " + Zegar.time + "\n";
        fs.write(s.getBytes());
        fs.close();
        Main.stage.setScene(new HighScores().scene);
    }

}
