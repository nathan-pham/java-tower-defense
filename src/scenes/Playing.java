package src.scenes;

import java.awt.Color;
import java.awt.Graphics;
import src.main.Game;

public class Playing extends GameScene implements SceneMethods {

    public Playing(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics ctx) {

        ctx.setColor(Color.RED);
        ctx.fillRect(0, 0, game.SIZE, game.SIZE);

    }

}
