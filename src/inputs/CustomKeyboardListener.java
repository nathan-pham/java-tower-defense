package src.inputs;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import src.main.GameStates;

public class CustomKeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A was pressed");
            GameStates.gameState = GameStates.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
