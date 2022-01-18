package src.main;

import java.awt.Graphics;


public class Render {

    private Game game;

    // constructor
    public Render(Game game) {

        this.game = game;

    }

    public void render(Graphics ctx) {
        
        switch (GameStates.gameState) {

            case SETTINGS:
                game.getSettings().render(ctx);
                break;

            case PLAYING:
                game.getPlaying().render(ctx);
                break;

            case MENU:
                game.getMenu().render(ctx);
                break;

        }

    }

}