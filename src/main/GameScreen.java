package src.main;

import javax.swing.JPanel;

import src.inputs.CustomKeyboardListener;
import src.inputs.CustomMouseListener;

import java.awt.Dimension;
import java.awt.Graphics;

public class GameScreen extends JPanel {

    private Game game;

    private CustomKeyboardListener keyboardListener;
    private CustomMouseListener mouseListener;

    // constructor
    public GameScreen(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(game.SIZE, game.SIZE));
    }

    public void initInputs() {

        // initialize variables
        keyboardListener = new CustomKeyboardListener();
        mouseListener = new CustomMouseListener(game);

        // add listeners to game
        addKeyListener(keyboardListener);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);

        // focus on window
        requestFocus();

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);
        game.getRender().render(ctx);

    }

}
