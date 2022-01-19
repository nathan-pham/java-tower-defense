package src.inputs;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static src.main.GameStates.*;

public class CustomKeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_A:
                SetGameState(PLAYING);
                break;
            case KeyEvent.VK_D:
                SetGameState(MENU);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
