package src.helpers;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.ArrayList;

import java.awt.image.BufferedImage;

public class LoadSave {

    public static BufferedImage GetSpriteAtlas() {

        BufferedImage spriteAtlas = null;
        InputStream inputStream = LoadSave.class.getResourceAsStream("/res/spriteatlas.png");

        try {
            spriteAtlas = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spriteAtlas;

    }

    private static File CreateFile(String name) {

        File file = new File(String.format("./res/%s.txt", name));

        if(file.exists()) {
            System.out.println("File already exists!");
            return file;
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;

    }

    private static void WriteToFile(File file, int[] idArray) {

        try {
            PrintWriter printWriter = new PrintWriter(file);
            for(Integer id : idArray) {
                printWriter.println(id);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Integer> ReadFromFile(String name) {

        File file = new File(String.format("./res/%s.txt", name));

        ArrayList<Integer> fileLines = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                fileLines.add(scanner.nextInt());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileLines;

    }

    public static void CreateLevel(String name, int[] idArray) {

        File file = LoadSave.CreateFile(name);

        if(file != null) {
            WriteToFile(file, idArray);
        }

    }

    public static int[][] LoadDefaultLevel() {

        ArrayList<Integer> fileLines = ReadFromFile("level");

        int levelSize = 20;
        int[][] level = new int[levelSize][levelSize];

        for(int i = 0; i < levelSize; i++) {
            for(int j = 0; j < levelSize; j++) {
                level[i][j] = fileLines.get(j % levelSize + i * levelSize);
            }
        }

        return level;

    }

}
