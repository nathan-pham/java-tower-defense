package src.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import src.objects.Tile;

public class TileButton extends Button {
    private Tile tile;

    // tile.getSprite(), tile.getId()

    public TileButton(Tile tile, int x, int y, int width, int height) {
        super("", x, y, width, height);
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public void draw(Graphics ctx) {

        ctx.drawImage(this.tile.getSprite(), x, y, width, height, null);

        if(mouseOver) {
            ctx.setColor(new Color(1, 1, 1, 0.3f));
            ctx.fillRect(x, y, width, height);
        }

    }
    
}
