package src.managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import src.helpers.LoadSave;
import src.objects.Tile;

public class TileManager {

    public Tile GRASS, WATER, ROAD;
    public BufferedImage spriteAtlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public static final int TILE_SIZE = 32;

    public TileManager() {

        loadAtlas();
        createTiles();

    }

    public void createTiles() {

        int id = 0;
        tiles.add(GRASS = new Tile(getSprite(8, 1), id++, "Grass"));
        tiles.add(WATER = new Tile(getSprite(0, 6), id++, "Water"));
        tiles.add(ROAD  = new Tile(getSprite(9, 0), id++, "Road"));

    }

    public void loadAtlas() {
        spriteAtlas = LoadSave.getSpriteAtlas();
    }

    public Tile getTile(int id) {
        return tiles.get(id);
    }

    public BufferedImage getSprite(int id) {
        return getTile(id).getSprite();
    }

    private BufferedImage getSprite(int x, int y) {

        return spriteAtlas.getSubimage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

    }

}
