package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;

import java.io.IOException;

public class SizeSelectorController {
    public static int width;
    public static int height;
    @FXML
    private Slider sliderWidth;
    @FXML
    private Slider sliderHeight;
    @FXML
    public void startG() throws IOException {
        width = (int) sliderWidth.getValue();
        height = (int) sliderHeight.getValue();
        Image image = new Image("/sample/image/1547367999_1.jpg");
        Main.stage.setScene(new GameWindow(image, width, height).scene);
    }
}
