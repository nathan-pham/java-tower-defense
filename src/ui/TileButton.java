package src.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileButton extends Button {
    
    private BufferedImage sprite;
    public int id;

    public TileButton(BufferedImage sprite, int id, int x, int y, int width, int height) {
        super("", x, y, width, height);
        this.sprite = sprite;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void draw(Graphics ctx) {
        ctx.drawImage(sprite, x, y, width, height, null);
    }
    
}
