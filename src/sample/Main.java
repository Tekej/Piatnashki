package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        primaryStage.setTitle("PuzzleGame");
        primaryStage.setScene(new MainMenu().getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
