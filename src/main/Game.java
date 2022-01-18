package src.main;

import javax.swing.JFrame;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

import java.lang.Runnable;

import src.inputs.CustomKeyboardListener;
import src.inputs.CustomMouseListener;

public class Game extends JFrame implements Runnable {

    private BufferedImage spriteAtlas;
    private GameScreen gameScreen;
    private Thread gameThread;

    private final double FPS_SET = 60.0;
    private final double UPS_SET = 30.0;
    private final int SIZE = 640;

    private CustomKeyboardListener keyboardListener;
    private CustomMouseListener mouseListener;

    // constructor
    public Game() {

        importSpriteAtlas();

        setSize(SIZE, SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit program when x clicked
        setResizable(false);

        gameScreen = new GameScreen(SIZE, spriteAtlas);
        add(gameScreen);
        pack();

        setLocationRelativeTo(null); // center frame
        setVisible(true);

    }

    // initialize inputs
    private void initInputs() {

        // initialize variables
        keyboardListener = new CustomKeyboardListener();
        mouseListener = new CustomMouseListener();

        // add listeners to game
        addKeyListener(keyboardListener);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);

        // focus on window
        requestFocus();

    }

    // import an image
    public void importSpriteAtlas() {

        InputStream inputStream = getClass().getResourceAsStream("/res/spriteatlas.png");

        try {
            spriteAtlas = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // update game
    private void updateGame() {

    }

    // start the gameThread
    private void start() {

        gameThread = new Thread(this) {
        };
        gameThread.start();

    }

    // run the gameThread
    @Override
    public void run() {

        // initialize variables
        double timePerUpdate = 1_000_000_000.0 / FPS_SET;
        double timePerFrame = 1_000_000_000.0 / UPS_SET;

        long lastUpdate = System.nanoTime();
        long lastFrame = System.nanoTime();

        long lastTimeCheck = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        long nanoTime;

        while (true) {

            nanoTime = System.nanoTime();

            // render
            if (nanoTime - lastFrame >= timePerFrame) {
                lastFrame = nanoTime;
                repaint();
                frames++;
            }

            // update
            if (nanoTime - lastUpdate >= timePerUpdate) {
                lastUpdate = nanoTime;
                updateGame();
                updates++;
            }

            // log fps and ups
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {

                System.out.printf("FPS: %d | UPS: %d\n", frames, updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();

            }

        }

    }

    // main method
    public static void main(String[] args) {

        Game game = new Game();
        game.initInputs();
        game.start();

    }

}