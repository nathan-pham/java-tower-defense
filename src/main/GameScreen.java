package src.main;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import java.util.Random;

public class GameScreen extends JPanel {

    private int tileCount = 20;
    private int tileSize = 0;

    private Random random;

    BufferedImage spriteAtlas;

    // constructor
    public GameScreen(int size, BufferedImage spriteAtlas) {

        setPreferredSize(new Dimension(size, size));
        tileSize = size / tileCount;

        random = new Random();

        this.spriteAtlas = spriteAtlas;

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);

        // initialize a grid
        for(int y = 0; y < tileCount; y++) {
            for(int x = 0; x < tileCount; x++) {
                ctx.setColor(getRandomColor());
                ctx.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }

    }

    // generate a random color
    private Color getRandomColor() {

        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }

}
