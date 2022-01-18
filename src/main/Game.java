package src.main;

import javax.swing.JFrame;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame {

    private GameScreen gameScreen;
    private int size = 640;

    private BufferedImage spriteAtlas;

    // constructor
    public Game() {

        importSpriteAtlas();

        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        // exit program when x clicked
        setResizable(false);

        gameScreen = new GameScreen(size, spriteAtlas);
        add(gameScreen);
        pack();

        setLocationRelativeTo(null);                    // center frame
        setVisible(true);

    }

    // import an image
    public void importSpriteAtlas() {

        InputStream inputStream = getClass().getResourceAsStream("/res/spriteatlas.png");

        try {
            spriteAtlas = ImageIO.read(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    // main method
    public static void main(String[] args) {

        Game game = new Game();
        
    }

}