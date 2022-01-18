package src.main;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;

public class Render {

    private GameScreen gameScreen;

    private BufferedImage spriteAtlas;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    private Random random;

    // constructor
    public Render(GameScreen gameScreen) {

        this.gameScreen = gameScreen;

        importSpriteAtlas();
        loadSprites();

        random = new Random();

    }

    public void render(Graphics ctx) {

        int tileCount = gameScreen.tileCount;
        int tileSize = gameScreen.tileSize;
        
        switch (GameStates.gameState) {

            case SETTINGS:
                break;

            case PLAYING:
                break;

            case MENU:
                for(int y = 0; y < tileCount; y++) {
                    for(int x = 0; x < tileCount; x++) {
                        ctx.drawImage(sprites.get(random.nextInt(sprites.size())), x * tileSize, y * tileSize, tileSize, tileSize, null, null);
                        // ctx.setColor(getRandomColor());
                        // ctx.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
                    }
                }

                break;

        }

    }

    // import spriteAtlas
    public void importSpriteAtlas() {

        InputStream inputStream = getClass().getResourceAsStream("/res/spriteatlas.png");

        try {
            spriteAtlas = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // load sprites from the spriteAtlas
    private void loadSprites() {

        for(int y = 0; y < 10; y++) {
            for(int x = 0; x < 10; x++) {
                sprites.add(spriteAtlas.getSubimage(x * 32, y * 32, 32, 32));
            }
        }

    }


}