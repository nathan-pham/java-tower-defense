package src.objects;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage sprite;
    private int id;
    private String name;

    public Tile(BufferedImage sprite, int id, String name) {

        this.sprite = sprite;
        this.name = name;
        this.id = id;

    }

    public BufferedImage getSprite() {
        return sprite;
    }

    // auto generated getters and setters
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

}
