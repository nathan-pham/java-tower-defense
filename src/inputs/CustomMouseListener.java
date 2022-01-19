package src.inputs;

import java.awt.event.MouseMotionListener;

import static src.main.GameStates.*;
import src.main.Game;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class CustomMouseListener implements MouseMotionListener, MouseListener {

    private Game game;

    public CustomMouseListener(Game game) {
        this.game = game;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {

            int x = e.getX();
            int y = e.getY();

            switch(gameState) {
                case MENU:
                    game.getMenu().mouseClicked(x, y);
                    break;
                case PLAYING:
                    game.getPlaying().mouseClicked(x, y);
                    break;
                case SETTINGS:
                    game.getSettings().mouseClicked(x, y);
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {

            int x = e.getX();
            int y = e.getY();

            switch(gameState) {
                case MENU:
                    game.getMenu().mousePressed(x, y);
                    break;
                case PLAYING:
                    game.getPlaying().mousePressed(x, y);
                    break;
                case SETTINGS:
                    game.getSettings().mousePressed(x, y);
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {

            int x = e.getX();
            int y = e.getY();

            switch(gameState) {
                case MENU:
                    game.getMenu().mouseReleased(x, y);
                    break;
                case PLAYING:
                    game.getPlaying().mouseReleased(x, y);
                    break;
                case SETTINGS:
                    game.getSettings().mouseReleased(x, y);
                    break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        switch(gameState) {
            case MENU:
                game.getMenu().mouseMoved(x, y);
                break;
            case PLAYING:
                game.getPlaying().mouseMoved(x, y);
                break;
            case SETTINGS:
                game.getSettings().mouseMoved(x, y);
                break;
        }

    }
    
}
