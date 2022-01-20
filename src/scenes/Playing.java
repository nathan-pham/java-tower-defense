package src.scenes;

import java.awt.Graphics;

import src.managers.TileManager;
import src.helpers.LevelBuilder;

import static src.main.GameStates.*;
import src.main.Game;

import src.ui.BottomBar;
import src.ui.Button;

public class Playing extends GameScene implements SceneMethods {

    private int[][] level;
    private TileManager tileManager;

    private BottomBar bottomBar;

    public Playing(Game game) {

        super(game);

        level = LevelBuilder.getLevelData();
        tileManager = new TileManager();

        bottomBar = new BottomBar(0, game.WIDTH, game.WIDTH, game.HEIGHT - game.WIDTH, this);

    }

    @Override
    public void render(Graphics ctx) {

        // ctx.setColor(Color.RED);
        // ctx.fillRect(0, 0, game.SIZE, game.SIZE);

        for (int y = 0; y < level.length; y++) {
            for (int x = 0; x < level[y].length; x++) {
                int id = level[y][x];
                ctx.drawImage(tileManager.getSprite(id), x * TILE_SIZE, y * TILE_SIZE, null);
            }
        }

        // bMenu.draw(ctx);
        bottomBar.draw(ctx);
    }

    // event listeners
    @Override
    public void mouseClicked(int x, int y) {
        bottomBar.mouseClicked(x, y);
    }

    // get tile manager
    public TileManager getTileManager() {
        return tileManager;
    }
}
