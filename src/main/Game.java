package src.main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private GameScreen gameScreen;

    // constructor
    public Game() {

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // exit program when x clicked
        setLocationRelativeTo(null);                // center frame

        this.gameScreen = new GameScreen();
        add(this.gameScreen);

    }

    // main method
    public static void main(String[] args) {

        Game game = new Game();
        
    }

}