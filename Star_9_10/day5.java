package Star_9_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) throws FileNotFoundException{
        // PART 1 -----------------------------------------------------
        File inputFile1 = new File("Star_9_10/input.txt");
        Scanner sc1 = new Scanner(inputFile1);
        int[][] map1 = new int[1000][1000];

        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                map1[i][j] = 0;
            }
        }

        while (sc1.hasNextLine()){
            // Init coordinate variables
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;

            // Grab line, separate/assign coord variables
            String[] curLine = sc1.nextLine().split(" ");
            x1 = Integer.parseInt(curLine[0].split(",")[0]);
            y1 = Integer.parseInt(curLine[0].split(",")[1]);
            x2 = Integer.parseInt(curLine[2].split(",")[0]);
            y2 = Integer.parseInt(curLine[2].split(",")[1]);

            if (x1 != x2 && y1 != y2){
                continue;
            }

            // Add vertical line
            if (x1 == x2){
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++){
                    map1[i][x1]++;
                }
            }
            // Add horizontal line
            else if (y1 == y2){
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
                    map1[y1][i]++;
                }
            }
        }
        sc1.close();

        // Count up overlaps of 2 or greater
        int counter1 = 0;
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                if (map1[i][j] >= 2){
                    counter1++;
                }
            }
        }
        System.out.println("Result: " + counter1);
        // PART 1 -----------------------------------------------------

        // PART 2 -----------------------------------------------------
        final int DIMENSION_SIZE = 1000; 
        File inputFile = new File("Star_9_10/input.txt");
        Scanner sc = new Scanner(inputFile);
        int[][] map = new int[DIMENSION_SIZE][DIMENSION_SIZE]; 

        for (int i = 0; i < DIMENSION_SIZE; i++){
            for (int j = 0; j < DIMENSION_SIZE; j++){
                map[i][j] = 0;
            }
        }

        while (sc.hasNextLine()){
            // Init coordinate variables
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;

            // Grab line, separate/assign coord variables
            String[] curLine = sc.nextLine().split(" ");
            x1 = Integer.parseInt(curLine[0].split(",")[0]);
            y1 = Integer.parseInt(curLine[0].split(",")[1]);
            x2 = Integer.parseInt(curLine[2].split(",")[0]);
            y2 = Integer.parseInt(curLine[2].split(",")[1]);

            // Add vertical line
            if (x1 == x2){
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++){
                    map[i][x1]++;
                }
            }
            // Add horizontal line
            else if (y1 == y2){
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
                    map[y1][i]++;
                }
            }
            // Add positive slope line
            else if ((x1 < x2 && y1 > y2) || (x1 > x2 && y1 < y2)){
                for (int i = Math.min(x1, x2), j = Math.max(y1, y2); i <= Math.max(x1, x2) && j >= Math.min(y1, y2); i++, j--){
                    map[j][i]++;
                }
            }
            // Add negative slope line
            else {
                for (int i = Math.min(x1, x2), j = Math.min(y1, y2); i <= Math.max(x1, x2) && j <= Math.max(y1, y2); i++, j++){
                    map[j][i]++;
                }
            }
        }
        sc.close();

        // Count up overlaps of 2 or greater
        int counter = 0;
        for (int i = 0; i < DIMENSION_SIZE; i++){
            for (int j = 0; j < DIMENSION_SIZE; j++){
                if (map[i][j] >= 2){
                    counter++;
                }
            }
        }
        System.out.println("Result: " + counter);
        // PART 2 -----------------------------------------------------
    }
}
