package src.scenes;

import java.awt.Graphics;
import src.main.Game;

public class Menu extends GameScene implements SceneMethods {

    public Menu(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics ctx) {

        for(int y = 0; y < TILE_COUNT; y++) {
            for(int x = 0; x < TILE_COUNT; x++) {
                ctx.drawImage(sprites.get(random.nextInt(sprites.size())), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null, null);
                // ctx.setColor(getRandomColor());
                // ctx.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

    }

}
