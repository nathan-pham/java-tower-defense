package src.main;

import javax.swing.JFrame;
import java.lang.Runnable;

import src.scenes.Settings;
import src.scenes.Playing;
import src.scenes.Menu;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private Thread gameThread;

    final double FPS_SET = 60.0;
    final double UPS_SET = 30.0;
    // public final int SIZE = 400;

    public final int WIDTH = 400;
    public final int HEIGHT = 475;

    private Render render;
    private Settings settings;
    private Playing playing;
    private Menu menu;

    // constructor
    public Game() {

        setSize(WIDTH, HEIGHT);
        setTitle("Java | Tower Defense");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit program when x clicked
        setResizable(false);

        render = new Render(this);
        initScenes();

        gameScreen = new GameScreen(this);
        add(gameScreen);
        pack();

        setLocationRelativeTo(null); // center frame
        setVisible(true);

    }

    // initialize scenes
    private void initScenes() {

        settings = new Settings(this);
        playing = new Playing(this);
        menu = new Menu(this);

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
        game.gameScreen.initInputs();
        game.start();

    }

    // getters and setters
    public Render getRender() {
        return render;
    }

    public Settings getSettings() {
        return this.settings;
    }

    public Playing getPlaying() {
        return this.playing;
    }

    public Menu getMenu() {
        return this.menu;
    }

}