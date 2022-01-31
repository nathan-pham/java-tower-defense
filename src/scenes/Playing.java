package src.scenes;

import java.awt.Graphics;

import src.managers.TileManager;
import src.objects.Tile;
import src.helpers.LevelBuilder;
import src.helpers.LoadSave;

import static src.main.GameStates.*;
import src.main.Game;

import src.ui.BottomBar;
import src.ui.Theme;

import src.helpers.Utils;

public class Playing extends GameScene implements SceneMethods {

    private int[][] level;
    private TileManager tileManager;

    private BottomBar bottomBar;

    private int lastTileX, lastTileY, lastTileId;
    private int mouseX, mouseY;

    public Playing(Game game) {

        super(game);

        tileManager = new TileManager();
        bottomBar = new BottomBar(0, game.WIDTH, game.WIDTH, game.HEIGHT - game.WIDTH, this);

        level = LoadSave.GetLevelData();

    }

    // get tile manager
    public TileManager getTileManager() {
        return tileManager;
    }

    // save level
    public void saveLevel() {
        LoadSave.SaveLevelData(level);
    }

    @Override
    public void render(Graphics ctx) {

        // ctx.setColor(Color.RED);
        // ctx.fillRect(0, 0, game.SIZE, game.SIZE);

        for (int y = 0; y < level.length; y++) {
            for (int x = 0; x < level[y].length; x++) {
                int id = level[y][x];
                ctx.drawImage(tileManager.getSprite(id), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            }
        }

        // bMenu.draw(ctx);
        drawSelectedTile(ctx);
        bottomBar.draw(ctx);

    }

    private void drawSelectedTile(Graphics ctx) {

        Tile selectedTile = bottomBar.getSelectedTile();
        if (selectedTile != null) {
            ctx.drawImage(selectedTile.getSprite(), mouseX, mouseY, TILE_SIZE, TILE_SIZE, null);
        }

    }

    private void setSelectedTile(int x, int y) {
        Tile selectedTile = bottomBar.getSelectedTile();
        if (selectedTile != null && y <= game.WIDTH) {
            int tileX = x / TILE_SIZE;
            int tileY = y / TILE_SIZE;
            int tileId = selectedTile.getId();

            if(tileX == lastTileX && tileY == lastTileY && tileId == lastTileId) {
                return;
            }

            lastTileX = tileX;
            lastTileY = tileY;
            lastTileId = tileId;

            // fail silently
            try {
                level[tileY % TILE_COUNT][tileX % TILE_COUNT] = tileId;
            } catch(ArrayIndexOutOfBoundsException e) {
            }
            
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        super.mouseMoved(x, y);
        mouseX = (x / TILE_SIZE) * TILE_SIZE;
        mouseY = (y / TILE_SIZE) * TILE_SIZE; // (int) Math.floor(y / TILE_COUNT) * TILE_COUNT;
    }

    // event listeners
    @Override
    public void mouseClicked(int x, int y) {
        bottomBar.mouseClicked(x, y);
        setSelectedTile(mouseX, mouseY);
    }

    @Override
    public void mouseDragged(int x, int y) {
        setSelectedTile(x, y);
    }

}
