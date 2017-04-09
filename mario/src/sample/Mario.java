package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Mario implements Runnable {
    private Image marioRightStop;
    private Image marioRightRun;
    private Image marioLeftStop;
    private Image marioLeftRun;
    private Image marioRightSpace;
    private Image marioLeftSpace;
    public static ImageView marioImageView;
    private static int directionX = 0; // 1-> right -1 -> left
    private int anim = 1;
    public  static int speed = 1;
    public static double dv = 0.1;
    public static boolean space = false;
    public static boolean left = false;
    public static boolean right = true;
    public static boolean top = false;
    public static boolean inBloc = false;

    public Mario() {
        marioRightStop = new Image("file:src/sample/images/marioArretDroite.png");
        marioRightRun =  new Image("file:src/sample/images/marioRightRun.png");
        marioLeftRun =   new Image("file:src/sample/images/marioLeftRun.png");
        marioLeftStop = new Image("file:src/sample/images/marioLeftStop.png");
        marioRightSpace = new Image("file:src/sample/images/marioRightSpace.png");
        marioLeftSpace = new Image("file:src/sample/images/marioLeftSpace.png");
        marioImageView = new ImageView(marioRightStop);
        marioImageView.setFitWidth(28);
        marioImageView.setFitHeight(50);

        marioImageView.setLayoutX(Main.WIDTH/5);
        marioImageView.setLayoutY(Background.FOOTER);

        Main.root.getChildren().add(marioImageView);
    }

    public static void setDirectionX(int dir) {
        directionX = dir;
    }

    public static int getDirectionX() {
        return directionX;
    }
    private void setAnimationImage() {
        if (directionX == 1 && anim == 1 && !space) {
            marioImageView.setImage(marioRightRun);
            anim = 0;
        } else if (directionX == 1 && anim == 0 && !space) {
            marioImageView.setImage(marioRightStop);
            anim = 1;
        }  else if (directionX == -1 && anim == 1 && !space) {
            marioImageView.setImage(marioLeftRun);
            anim = 0;
        } else if (directionX == -1 && anim == 0 && !space) {
            marioImageView.setImage(marioLeftStop);
            anim = 1;
        } else if (right && !space) {
            marioImageView.setImage(marioRightStop);
            anim = 0;

        } else if (left && !space) {
            marioImageView.setImage(marioLeftStop);
            anim = 0;
        }else if (space && right) {
            marioImageView.setImage(marioRightSpace);
            jump();

        } else if (space && left) {
            marioImageView.setImage(marioLeftSpace);
            jump();
        }
        if (inBloc) {
            jump();
        }

        if (marioImageView.getLayoutY() > Background.FOOTER) {
            System.out.println(true);
            marioImageView.setLayoutY(Background.FOOTER);
            if (left)
                marioImageView.setImage(marioLeftStop);
            else
                marioImageView.setImage(marioRightStop);
            space = false;
            inBloc = false;
        }



    }

    public static double getMarioPosY() {
        return marioImageView.getLayoutY();
    }

    private void jump() {

        if (top) {
            speed -= dv;
            marioImageView.setLayoutY(marioImageView.getLayoutY() - (speed));
            if (speed <= 0) top = false;
        } else {
            speed += dv;
            marioImageView.setLayoutY(marioImageView.getLayoutY() + (speed));
        }
    }

    @Override
    public void run() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                setAnimationImage();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }


            }
        }.start();

    }
}
