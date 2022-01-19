package src.scenes;

import java.awt.Graphics;

public interface SceneMethods {

    public void render(Graphics ctx);
    
    // event listeners
    public void mouseClicked(int x, int y);
    public void mouseMoved(int x, int y);
    
}
