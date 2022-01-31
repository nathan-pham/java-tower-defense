package src.helpers;

import java.util.ArrayList;

public class Utils {

    public static int[][] ArrayListAsArray(ArrayList<Integer> arrayList, int levelSize) {
        int[][] level = new int[levelSize][levelSize];

        for(int i = 0; i < levelSize; i++) {
            for(int j = 0; j < levelSize; j++) {
                level[j][i] = arrayList.get(j * levelSize + i);
            }
        }

        return level;
    }

    public static int[] FlattenArray(int[][] array) {
        int[] flattenedArray = new int[array.length * array[0].length];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                flattenedArray[i * array[i].length + j] = array[i][j];
            }
        }

        return flattenedArray;
    }
    
}
