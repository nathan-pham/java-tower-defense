package src.scenes;

import java.awt.Graphics;
import java.awt.Color;

import static src.main.GameStates.*;
import src.main.Game;

import src.ui.Button;

public class Settings extends GameScene implements SceneMethods {

    Button bMenu;

    public Settings(Game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics ctx) {

        ctx.setColor(Color.BLACK);
        ctx.fillRect(0, 0, game.SIZE, game.SIZE);
        bMenu.draw(ctx);

    }

    // initialize buttons
    public void initButtons() {
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
