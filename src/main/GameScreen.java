package src.main;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;

public class GameScreen extends JPanel {

    private Render render;
    private Game game;

    int tileCount = 20;
    int tileSize = 0;

    // constructor
    public GameScreen(Game game) {

        setPreferredSize(new Dimension(game.SIZE, game.SIZE));
        tileSize = game.SIZE / tileCount;

        render = new Render(this);
        this.game = game;

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);
        render.render(ctx);

    }

}
