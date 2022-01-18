package src.main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;
    private int size = 320;

    // constructor
    public Game() {

        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        // exit program when x clicked
        setResizable(false);

        gameScreen = new GameScreen(size);
        add(gameScreen);
        pack();

        setLocationRelativeTo(null);                    // center frame
        setVisible(true);

    }

    // main method
    public static void main(String[] args) {

        Game game = new Game();
        
    }

}