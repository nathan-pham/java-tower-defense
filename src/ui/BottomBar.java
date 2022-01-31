package src.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import static src.main.GameStates.*;

import src.managers.TileManager;
import src.objects.Tile;
import src.scenes.Playing;

public class BottomBar {

    private int x, y, width, height;

    private Playing gameScene;
    private Button bMenu, bSave;

    private ArrayList<TileButton> tile_buttons = new ArrayList<>();
    private Tile selectedTile = null;

    private final int MARGIN = 10;

    public BottomBar(int x, int y, int width, int height, Playing gameScene) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.gameScene = gameScene;

        initButtons();

    }

    public Tile getSelectedTile() {
        return selectedTile;
    }

    // initialize buttons
    public void initButtons() {

        int bHeight = 45;

        int centerY = getCenterY(bHeight);

        gameScene.buttons.add(bMenu = new Button("Menu", MARGIN, centerY - (Button.BOX_SHADOW / 2), 100, bHeight));
        gameScene.buttons
                .add(bSave = new Button("Save", MARGIN * 2 + 100, centerY - (Button.BOX_SHADOW / 2), 100, bHeight));

        for (Tile tile : gameScene.getTileManager().tiles) {
            TileButton tileButton = new TileButton(tile,
                    gameScene.game.WIDTH - bHeight - MARGIN - ((bHeight + MARGIN) * tile.getId()), centerY, bHeight,
                    bHeight);

            gameScene.buttons.add(tileButton);
            tile_buttons.add(tileButton);
        }

        // selectedTile = tile_buttons.get(0).getTile();

    }

    private int getCenterY(int componentHeight) {
        return y + (height / 2) - (componentHeight / 2);
    }

    // draw method
    public void draw(Graphics ctx) {

        ctx.setColor(Theme.WHITE);
        ctx.fillRect(x, y, width, height);

        drawTileButtons(ctx);
        drawSelectedTile(ctx);

    }

    public void drawTileButtons(Graphics ctx) {
        for (Button button : gameScene.buttons) {
            button.draw(ctx);
        }
    }

    public void drawSelectedTile(Graphics ctx) {

        if (selectedTile != null) {
            int x = gameScene.game.WIDTH - gameScene.TILE_SIZE - MARGIN;
            int y = MARGIN;

            ctx.setColor(Theme.WHITE);
            ctx.fillRect(x - 2, y - 2, gameScene.TILE_SIZE + 4, gameScene.TILE_SIZE + 5);
            ctx.drawImage(selectedTile.getSprite(), x, y, gameScene.TILE_SIZE, gameScene.TILE_SIZE, null);
        }
    }

    // event listeners
    public void mouseClicked(int x, int y) {

        gameScene.setCursorState(gameScene.DEFAULT_MOUSE);
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        } else if (bSave.getBounds().contains(x, y)) {
            gameScene.saveLevel();
        } else {
            for (TileButton button : tile_buttons) {
                if (button.getBounds().contains(x, y)) {
                    selectedTile = button.getTile() == selectedTile ? null : button.getTile();
                    break;
                }
            }
        }

    }

}
