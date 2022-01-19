package src.scenes;

import java.awt.Color;
import java.awt.Graphics;
import src.main.Game;

public class Settings extends GameScene implements SceneMethods {

    public Settings(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics ctx) {

        ctx.setColor(Color.BLACK);
        ctx.fillRect(0, 0, game.SIZE, game.SIZE);

    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(int x, int y) {
        // TODO Auto-generated method stub
        
    }

}
