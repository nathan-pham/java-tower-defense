package src.main;

public enum GameStates {

    SETTINGS, PLAYING, MENU;

    public static GameStates gameState = MENU;
    public static void SetGameState(GameStates state) {
        gameState = state;
    }

}
