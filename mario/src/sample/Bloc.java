package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by harut on 4/9/17.
 */
public class Bloc implements Runnable{
    private Image blocImage;
    private ImageView blocImageView;
    public boolean broken = false;
    private int speed = 10;
    private boolean top = false;
    private int dv = 2;

    public Bloc(int x,int y) {
        blocImage = new Image("file:src/sample/images/bloc.png");
        blocImageView = new ImageView(blocImage);
        blocImageView.setLayoutY(y);
        blocImageView.setLayoutX(x);
        blocImageView.setFitHeight(30);
        blocImageView.setFitWidth(30);

        Main.root.getChildren().addAll(blocImageView);
    }
        public boolean checker(double down1, double up1, double down2, double up2) {
        boolean check = false;
            for (int i = (int) down1; i <= up1 ; i++) {
                for (int j = (int)down2; j <= up2 ; j++) {
                    if (i == j) {
                        check = true;
                        break;
                    }
                }
            }
            return check;
        }
    @Override
    public void run() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Mario.getDirectionX() == 1) {
                    blocImageView.setLayoutX(blocImageView.getLayoutX() - Background.speed);
                } else if (Mario.getDirectionX() == -1) {
                    blocImageView.setLayoutX(blocImageView.getLayoutX() + Background.speed);
                }
                if (Mario.marioImageView.getLayoutX() + Mario.marioImageView.getFitWidth() > blocImageView.getLayoutX() &&
                        Mario.marioImageView.getLayoutX() + Mario.marioImageView.getFitWidth() < blocImageView.getLayoutX() - 20
                        //&& Mario.marioImageView.getLayoutY() <= blocImageView.getLayoutY() - blocImageView.getFitHeight()
                        //&& Mario.marioImageView.getLayoutY() - Mario.marioImageView.getFitHeight() >= blocImageView.getLayoutY()
                        && checker(Mario.marioImageView.getLayoutY()- Mario.marioImageView.getFitHeight(),
                        Mario.marioImageView.getLayoutY(),
                        blocImageView.getLayoutY()-blocImageView.getFitHeight(),blocImageView.getLayoutY())
                        ) {
                    Mario.setDirectionX(0);
                    System.out.println("mouse");
                    //Mario.marioImageView.setLayoutX(blocImageView.getLayoutX() - Mario.marioImageView.getFitWidth());
                }
                if (checker(Mario.marioImageView.getLayoutX(),Mario.marioImageView.getLayoutX()+Mario.marioImageView.getFitWidth(),
                        blocImageView.getLayoutX(),blocImageView.getLayoutX() + blocImageView.getFitWidth()) &&
                        Mario.marioImageView.getLayoutY() <= blocImageView.getLayoutY() + blocImageView.getFitHeight() &&
                        Mario.marioImageView.getLayoutY() > blocImageView.getLayoutY()) {
                    Mario.top = false;
                    Mario.marioImageView.setLayoutY(blocImageView.getLayoutY() + blocImageView.getFitHeight());
                    broken = true;
                    top = true;
                    speed = 10;
                    dv = 2;
                }

                if (checker(Mario.marioImageView.getLayoutX(),Mario.marioImageView.getLayoutX()+Mario.marioImageView.getFitWidth(),
                        blocImageView.getLayoutX(),blocImageView.getLayoutX() + blocImageView.getFitWidth()-5) &&
                        Mario.marioImageView.getLayoutY() + Mario.marioImageView.getFitHeight() >= blocImageView.getLayoutY() &&
                        Mario.marioImageView.getLayoutY() + Mario.marioImageView.getFitHeight() <= blocImageView.getLayoutY() + blocImageView.getFitHeight()) {
                    Mario.marioImageView.setLayoutY(blocImageView.getLayoutY() - Mario.marioImageView.getFitHeight());

                    Mario.space = false;
                    Mario.inBloc = true;
                    Mario.speed = 5;
                    Mario.top = false;
                    System.out.println("xoz");
//                    if (Mario.getDirectionX() == 1)
//                        Mario.marioImageView.setLayoutX(Mario.marioImageView.getLayoutX() + Background.speed);
//                    if (Mario.getDirectionX() == -1)
//                        Mario.marioImageView.setLayoutX(Mario.marioImageView.getLayoutX() - Background.speed);
                }

                if (broken) {
                    jump();
                }
            }
        }.start();
    }

    private void jump() {

        if (top) {
            speed -= dv;
            blocImageView.setLayoutY(blocImageView.getLayoutY() - (speed));
            if (speed <= 0) top = false;
        } else {
            speed += dv;
            blocImageView.setLayoutY(blocImageView.getLayoutY() + (speed));
        }
    }
}
