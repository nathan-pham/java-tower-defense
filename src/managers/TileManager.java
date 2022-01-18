package src.managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import src.helpers.LoadSave;
import src.objects.Tile;

public class TileManager {

    public Tile GRASS, WATER, ROAD;
    public BufferedImage spriteAtlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {

        // loadAtlas();
        createTiles();

    }

    public void createTiles() {

        tiles.add(GRASS = new Tile(getSprite(8, 1)));
        tiles.add(WATER = new Tile(getSprite(6, 0)));
        tiles.add(ROAD  = new Tile(getSprite(9, 0)));

    }

    public void loadAtlas() {
        spriteAtlas = LoadSave.getSpriteAtlas();
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int x, int y) {

        final int TILE_SIZE = 32;
        return spriteAtlas.getSubimage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

    }

}
