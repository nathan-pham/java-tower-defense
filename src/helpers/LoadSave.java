package src.helpers;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
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

    public static File CreateFile(String name) {

        File file = new File(String.format("./res/%s.txt", name));

        try {
            file.createNewFile();
            // file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;

    }

    public static void WriteToFile() {

        File file = new File("./res/testTextFile.txt");

        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("Hello world!");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void ReadFromFile() {

        File file = new File("./res/testTextFile.txt");

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void CreateLevel(String name, int[] idArray) {

        File file = LoadSave.CreateFile(name);
        

    }

}
