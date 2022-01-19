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
        //     for(int x = 0; x < TILE_COUNT; x++) {
        //         ctx.drawImage(sprites.get(random.nextInt(sprites.size())), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null, null);
        //         // ctx.setColor(getRandomColor());
        //         // ctx.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        //     }
        // }

    }

    private void initButtons() {
        bPlaying = new Button("Play", 100, 100, 100, 50);

    }

    private void drawButton(Graphics ctx) {
        bPlaying.draw(ctx);
    }

    // event listeners
    @Override
    public void mouseClicked(int x, int y) {

        setCursorState(DEFAULT_MOUSE);
        if(bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAY);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {

        setCursorState(DEFAULT_MOUSE);
        bPlaying.setMouseOver(false);
        
        if(bPlaying.getBounds().contains(x, y)) {
            setCursorState(POINTER_MOUSE);
            bPlaying.setMouseOver(true);
        }

    }

    @Override
    public void mousePressed(int x, int y) {

        bPlaying.setMousePressed(false);
        if(bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMousePressed(true);
        }
        
    }

}
