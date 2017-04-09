package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    static Pane root;
    private Background background;
    private Mario mario;
    private Blocks blocks;
    static final int WIDTH = 800;
    static final int HEIGHT = 350;
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(createContent()));

        primaryStage.getScene().setOnKeyPressed(new KeyPressed());
        primaryStage.getScene().setOnKeyReleased(new KeyReleased());
        primaryStage.show();
    }

    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(WIDTH,HEIGHT);
        background = new Background();
        mario = new Mario();
        background.run();
        mario.run();
        blocks = new Blocks();

        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
