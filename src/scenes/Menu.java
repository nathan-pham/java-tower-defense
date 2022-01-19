package src.scenes;

import java.awt.Graphics;

import static src.main.GameStates.*;
import src.main.Game;

import src.ui.Theme;
import src.ui.Button;

public class Menu extends GameScene implements SceneMethods {

    private Button bPlaying, bSettings, bQuit;

    public Menu(Game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics ctx) {

        ctx.setColor(Theme.WHITE);
        ctx.fillRect(0, 0, game.SIZE, game.SIZE);

        drawButton(ctx);
        // for(int y = 0; y < TILE_COUNT; y++) {
        // for(int x = 0; x < TILE_COUNT; x++) {
        // ctx.drawImage(sprites.get(random.nextInt(sprites.size())), x * TILE_SIZE, y *
        // TILE_SIZE, TILE_SIZE, TILE_SIZE, null, null);
        // // ctx.setColor(getRandomColor());
        // // ctx.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        // }
        // }

    }

    private void initButtons() {

        int bWidth = 150;
        int bHeight = 45;

        int centerX = game.SIZE / 2 - bWidth / 2;
        int minY = 200;
        int margin = bHeight + 25;

        bPlaying = new Button("Play", centerX, minY, bWidth, bHeight);
        bSettings = new Button("Settings", centerX, minY + margin, bWidth, bHeight);
        bQuit = new Button("Quit", centerX, minY + margin * 2, bWidth, bHeight);

    }

    private void drawButton(Graphics ctx) {
        bPlaying.draw(ctx);
        bSettings.draw(ctx);
        bQuit.draw(ctx);
    }

    // event listeners
    @Override
    public void mouseClicked(int x, int y) {

        setCursorState(DEFAULT_MOUSE);
        if (bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAY);
        } else if (bSettings.getBounds().contains(x, y)) {
            SetGameState(SETTINGS);
        } else if (bQuit.getBounds().contains(x, y)) {
            System.exit(0);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {

        resetMouseStates();

        Button[] buttons = { bPlaying, bSettings, bQuit };
        for (Button button : buttons) {
            if (button.getBounds().contains(x, y)) {
                setCursorState(POINTER_MOUSE);
                button.setMouseOver(true);
            }
        }

    }

    @Override
    public void mousePressed(int x, int y) {

        Button[] buttons = { bPlaying, bSettings, bQuit };
        for (Button button : buttons) {
            if (button.getBounds().contains(x, y)) {
                button.setMousePressed(true);
            }
        }

    }

    @Override
    public void mouseReleased(int x, int y) {
        resetMouseStates();
    }

    private void resetMouseStates(boolean resetCursor) {

        if (resetCursor) {
            setCursorState(DEFAULT_MOUSE);
        }

        bPlaying.resetMouseStates();
        bSettings.resetMouseStates();
        bQuit.resetMouseStates();

    }

    private void resetMouseStates() {
        resetMouseStates(true);
    }

}
