package src.main;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {

    private int tileCount = 20;
    private int tileSize = 0;

    private Random random;

    private BufferedImage spriteAtlas;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    // constructor
    public GameScreen(int size, BufferedImage spriteAtlas) {

        setPreferredSize(new Dimension(size, size));
        tileSize = size / tileCount;

        random = new Random();

        this.spriteAtlas = spriteAtlas;
        loadSprites();

    }

    private void loadSprites() {

        for(int y = 0; y < 10; y++) {
            for(int x = 0; x < 10; x++) {
                sprites.add(spriteAtlas.getSubimage(x * 32, y * 32, 32, 32));
            }
        }

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);

        // ctx.drawImage(sprites.get(19), 0, 0, tileSize, tileSize, null, null);

        // initialize a grid
        for(int y = 0; y < tileCount; y++) {
            for(int x = 0; x < tileCount; x++) {
                ctx.drawImage(sprites.get(random.nextInt(sprites.size())), x * tileSize, y * tileSize, tileSize, tileSize, null, null);
                // ctx.setColor(getRandomColor());
                // ctx.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }

    }

    // generate a random color
    private Color getRandomColor() {

        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }

}
