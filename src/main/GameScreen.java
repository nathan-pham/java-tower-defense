package src.main;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;

public class GameScreen extends JPanel {

    private Game game;

    // constructor
    public GameScreen(Game game) {

        setPreferredSize(new Dimension(game.SIZE, game.SIZE));

        this.game = game;

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);
        game.getRender().render(ctx);

    }

}
