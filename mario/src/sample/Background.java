package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * Created by harut on 4/8/17.
 */
public class Background implements Runnable {
    private Image backgroundImage;
    public static ImageView backgroundImageView1;
    public static ImageView backgroundImageView2;
    public static final int FOOTER = 244;
    public static int speed = 10;


    public Background() {
        backgroundImage = new Image("file:src/sample/images/fondEcran.png");
        backgroundImageView1 = new ImageView(backgroundImage);
        backgroundImageView1.setLayoutY(0);
        backgroundImageView1.setLayoutX(0);
//        backgroundImageView1.setFitWidth(Main.WIDTH);
//        backgroundImageView1.setFitHeight(Main.HEIGHT);

        backgroundImageView2 = new ImageView(backgroundImage);
        backgroundImageView2.setLayoutX(Main.WIDTH);
        backgroundImageView2.setLayoutY(0);
//        backgroundImageView2.setFitWidth(Main.WIDTH);
//        backgroundImageView2.setFitHeight(Main.HEIGHT);



        addImages();

    }

    private void addImages() {
        Main.root.getChildren().addAll(backgroundImageView1,backgroundImageView2);
    }


    @Override
    public void run() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Mario.getDirectionX() == 1) {
                    backgroundImageView1.setLayoutX(backgroundImageView1.getLayoutX() - speed);
                    backgroundImageView2.setLayoutX(backgroundImageView2.getLayoutX() - speed);
                    if (backgroundImageView1.getLayoutX() <= -Main.WIDTH) backgroundImageView1.setLayoutX(Main.WIDTH - 1);
                    if (backgroundImageView2.getLayoutX() <= -Main.WIDTH) backgroundImageView2.setLayoutX(Main.WIDTH - 1);
                } else if (Mario.getDirectionX() == -1) {
                    backgroundImageView1.setLayoutX(backgroundImageView1.getLayoutX() + speed);
                    backgroundImageView2.setLayoutX(backgroundImageView2.getLayoutX() + speed);
                    if (backgroundImageView1.getLayoutX() >= Main.WIDTH ) backgroundImageView1.setLayoutX(-Main.WIDTH + 1);
                    if (backgroundImageView2.getLayoutX() >= Main.WIDTH ) backgroundImageView2.setLayoutX(-Main.WIDTH + 1);
                }


            }
        }.start();
    }
}
