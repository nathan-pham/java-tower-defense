package src.scenes;

import java.awt.Graphics;

import src.managers.TileManager;
import src.helpers.LevelBuilder;
import src.main.Game;

public class Playing extends GameScene implements SceneMethods {

    private int[][] level;
    private TileManager tileManager;

    public Playing(Game game) {

        super(game);

        level = LevelBuilder.getLevelData();
        tileManager = new TileManager();
        
    }

    @Override
    public void render(Graphics ctx) {

        // ctx.setColor(Color.RED);
        // ctx.fillRect(0, 0, game.SIZE, game.SIZE);

        for(int y = 0; y < level.length; y++) {
            for(int x = 0; x < level[y].length; x++) {
                int id = level[y][x];
                ctx.drawImage(tileManager.getSprite(id), x * TILE_SIZE, y * TILE_SIZE, null);
            }
        }

    }

}
