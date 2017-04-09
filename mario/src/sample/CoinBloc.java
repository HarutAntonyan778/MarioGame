package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by harut on 4/9/17.
 */
public class CoinBloc extends Bloc {
    private Image blocImage = new Image("file:src/sample/images/CoinBox.gif");
    private Image emptyBlocImage;
    private double blocY;
    int speed = 5;
    double dv = 0.3;
  //  private ImageView blocImageView;

    public CoinBloc(int x, int y) {
        super(x,y,new Image("file:src/sample/images/CoinBox.png"));
        emptyBlocImage = new Image("file:src/sample/images/emptyCoinBox.png");
        blocY = blocImageView.getLayoutY();
//        blocImageView = new ImageView(blocImage);
//        blocImageView.setFitHeight(40);
     // blocImageView.setFitWidth(40);

       // Main.root.getChildren().add(blocImageView);
    }

    @Override
    protected void jump() {
        if (broken) {
            blocImageView.setImage(emptyBlocImage);
//            blocImageView.setFitHeight(30);
//            blocImageView.setFitWidth(30);
                speed -= dv;
                blocImageView.setLayoutY(blocImageView.getLayoutY() - (speed));
                if (speed <= 0) top = false;
            if (blocImageView.getLayoutY() >= blocY) {
                blocImageView.setLayoutY(blocY-13.5);
                broken = false;

            }
        }
        if (!broken)
            blocImageView.setLayoutY(blocY-13.5);
        super.jump();

    }
}
