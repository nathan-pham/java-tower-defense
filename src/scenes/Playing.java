package src.scenes;

import java.awt.Graphics;

import src.managers.TileManager;
import src.helpers.LevelBuilder;

import static src.main.GameStates.*;
import src.main.Game;

import src.ui.Theme;
import src.ui.Button;

public class Playing extends GameScene implements SceneMethods {

    private int[][] level;
    private TileManager tileManager;

    private Button bMenu;

    public Playing(Game game) {

        super(game);

        level = LevelBuilder.getLevelData();
        tileManager = new TileManager();

        initButtons();

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

        bMenu.draw(ctx);
    }

    // initialize buttons
    private void initButtons() {
        buttons.add(bMenu = new Button("Menu", 10, 10, 100, 45));
    }

    // event listeners
    @Override
    public void mouseClicked(int x, int y) {

        setCursorState(DEFAULT_MOUSE);
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        }

    }
}
