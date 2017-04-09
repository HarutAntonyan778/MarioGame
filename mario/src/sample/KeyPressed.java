package sample;


import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * Created by harut on 4/8/17.
 */
public class  KeyPressed implements EventHandler<KeyEvent> {


    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            Mario.setDirectionX(1);

        }  if (event.getCode() == KeyCode.LEFT) {
            Mario.setDirectionX(-1);
        }

        if (event.getCode() == KeyCode.UP && Mario.getMarioPosY() >= Background.FOOTER) {
            Mario.top = true;
            Mario.space = true;
            Mario.speed = 40;
            Mario.dv = 3.5;
        }

        if (event.getCode() == KeyCode.UP && Mario.inBloc) {
            Mario.top = true;
            Mario.space = true;
            Mario.speed = 18;
            Mario.dv = 1;
        }
    }
}
