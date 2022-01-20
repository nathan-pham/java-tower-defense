package src.ui;

import java.awt.Graphics;
import java.util.ArrayList;

import static src.main.GameStates.*;

import src.objects.Tile;
import src.scenes.Playing;

import src.ui.TileButton;

public class BottomBar {

    private int x, y, width, height;

    private Playing gameScene;
    private Button bMenu;

    // private ArrayList<Button> tile_buttons = new ArrayList<Button>();

    public BottomBar(int x, int y, int width, int height, Playing gameScene) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.gameScene = gameScene;

        initButtons();

    }

    // initialize buttons
    public void initButtons() {

        int bHeight = 45;
        int margin = 12;

        int centerY = getCenterY(bHeight) - (Button.BOX_SHADOW / 2);

        gameScene.buttons.add(bMenu = new Button("Menu", margin, centerY, 100, bHeight));

        for (Tile tile : gameScene.getTileManager().tiles) {
            gameScene.buttons.add(new TileButton(tile.getSprite(),
                    gameScene.game.WIDTH - bHeight - margin - ((bHeight + margin) * tile.getId()), centerY, bHeight,
                    bHeight));
        }

    }

    private int getCenterY(int componentHeight) {
        return y + (height / 2) - (componentHeight / 2);
    }

    // draw method
    public void draw(Graphics ctx) {

        ctx.setColor(Theme.WHITE);
        ctx.fillRect(x, y, width, height);

        for (Button button : gameScene.buttons) {
            button.draw(ctx);
        }

    }

    // event listeners
    public void mouseClicked(int x, int y) {

        gameScene.setCursorState(gameScene.DEFAULT_MOUSE);
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        }

    }

}
