package src.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileButton extends Button {
    
    private BufferedImage sprite;

    public TileButton(BufferedImage sprite, int x, int y, int width, int height) {
        super("", x, y, width, height);
        this.sprite = sprite;
    }

    @Override
    public void draw(Graphics ctx) {
        ctx.drawImage(sprite, x, y, width, height, null);
    }
    
}
