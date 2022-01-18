package src.helpers;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

import java.awt.image.BufferedImage;

public class LoadSave {

    public static BufferedImage getSpriteAtlas() {

        BufferedImage spriteAtlas = null;
        InputStream inputStream = LoadSave.class.getResourceAsStream("/res/spriteatlas.png");

        try {
            spriteAtlas = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spriteAtlas;

    }
    
}
