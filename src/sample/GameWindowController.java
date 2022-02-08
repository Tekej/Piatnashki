package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class GameWindowController {
    public GraphicsContext g;
    public Game game;
    @FXML
    Canvas canvas;
    @FXML
    Label zegar;

    public Zegar zgr;
    @FXML
    public void initialize() {
        Main.stage.setOnCloseRequest(event -> zgr.run = false);
        canvas.setOnMouseClicked(event -> {
            game.move((int) (event.getX() / (canvas.getWidth() / game.width)), (int) (event.getY() / (canvas.getHeight() / game.height)));
            paint();
        });
        g = canvas.getGraphicsContext2D();
        zgr = new Zegar();
        zgr.setZge(e-> Platform.runLater(() -> zegar.setText(e+"")));
        zgr.start();
    }
    public void setGame(Game game) {
        this.game = game;
        paint();
    }

    public void paint() {
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();
        for (int i = 0; i < game.solution.length; i++)
            for (int j = 0; j < game.solution[i].length; j++) {
                g.drawImage(game.solution[i][j], i * width / game.width, j * height / game.height, width / game.width, height / game.height);
            }
    }
}