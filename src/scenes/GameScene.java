package src.scenes;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Cursor;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Random;

import src.main.Game;

public class GameScene {

    public Game game;

    public Random random;

    public BufferedImage spriteAtlas;
    public ArrayList<BufferedImage> sprites = new ArrayList<>();

    public final int TILE_COUNT = 20;
    public final int TILE_SIZE;

    public final int DEFAULT_MOUSE = Cursor.DEFAULT_CURSOR;
    public final int POINTER_MOUSE = Cursor.HAND_CURSOR;

    public GameScene(Game game) {

        TILE_SIZE = game.SIZE / TILE_COUNT;
        this.game = game;
        
        importSpriteAtlas();
        loadSprites();

        random = new Random();

    }

    public Game getGame() {
        return this.game;
    }

    // set cursor state
    public void setCursorState(int cursorState) {
        game.setCursor(Cursor.getPredefinedCursor(cursorState));
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
