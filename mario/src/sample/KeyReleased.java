package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by harut on 4/8/17.
 */
public class KeyReleased implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT ) {
            Mario.setDirectionX(0);
            Mario.right = true;
            Mario.left = false;
        } else if (event.getCode() == KeyCode.LEFT) {
            Mario.setDirectionX(0);
            Mario.left = true;
            Mario.right = false;
        }
    }
}
