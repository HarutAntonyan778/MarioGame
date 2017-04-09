package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by harut on 4/10/17.
 */
public class Pipe implements Runnable {
    private Image pipe;
    private ImageView pipeImageView;

    public Pipe(int x,int height) {
        pipe = new Image("file:src/sample/images/Pipe.png");
        pipeImageView = new ImageView(pipe);
        pipeImageView.setLayoutX(x);
        pipeImageView.setLayoutY(Background.FOOTER - Mario.marioImageView.getFitHeight()+10);
        pipeImageView.setFitHeight(height);
        pipeImageView.setFitWidth(80);

        Main.root.getChildren().addAll(pipeImageView);

    }

    @Override
    public void run() {
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (Mario.getDirectionX() == 1) {
                    pipeImageView.setLayoutX(pipeImageView.getLayoutX() - Background.speed);
                } else if (Mario.getDirectionX() == -1) {
                    pipeImageView.setLayoutX(pipeImageView.getLayoutX() + Background.speed);
                }
            }
        }.start();

    }
}
