package Star_17_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day9 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_17_18/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        final int WIDTH_DIMENSION = 100; 
        final int HEIGHT_DIMENSION = 100;

        int[][] heightMap = new int[HEIGHT_DIMENSION][WIDTH_DIMENSION];

        int rowCounter = 0;
        while (sc.hasNextLine()){
            String[] numRow = sc.nextLine().split("");
            for (int columnCounter = 0; columnCounter < WIDTH_DIMENSION; columnCounter++){
                heightMap[rowCounter][columnCounter] = Integer.parseInt(numRow[columnCounter]);
            }
            rowCounter++;
        }
        sc.close();

        ArrayList<Integer> lowPointArr = new ArrayList<>();
        ArrayList<int[]> lowPointIndices = new ArrayList<>();

        for (int i = 0; i < HEIGHT_DIMENSION; i++){
            for (int j = 0; j < WIDTH_DIMENSION; j++){
                boolean lowPoint = true;
                int currentHeight = heightMap[i][j];
                if (j - 1 >= 0){
                    if (heightMap[i][j-1] <= currentHeight){
                        lowPoint = false;
                    }
                }
                if (i - 1 >= 0){
                    if (heightMap[i-1][j] <= currentHeight){
                        lowPoint = false;
                    }
                }
                if (j + 1 < WIDTH_DIMENSION){
                    if (heightMap[i][j+1] <= currentHeight){
                        lowPoint = false;
                    }
                }
                if (i + 1 < HEIGHT_DIMENSION){
                    if (heightMap[i+1][j] <= currentHeight){
                        lowPoint = false;
                    }
                }
                if (lowPoint){
                    lowPointArr.add(currentHeight);
                    lowPointIndices.add(new int[]{i, j});
                }
            }
        }

        long riskLevel = 0;
        for (int lowPointNum : lowPointArr){
            riskLevel += (lowPointNum + 1);
        }
        System.out.println("PART 1 : Risk Level: " + riskLevel);

        ArrayList<Integer> basinSizes = new ArrayList<>();
        for (int i = 0; i < lowPointArr.size(); i++){
            int xVal = lowPointIndices.get(i)[1];
            int yVal = lowPointIndices.get(i)[0];
            int curBasinSize = countFills(xVal, yVal, heightMap);
            basinSizes.add(curBasinSize);
        }

        Collections.sort(basinSizes, Collections.reverseOrder());

        System.out.println("PART 2 : Result: " + basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2));
    }

    public static int countFills(int xVal, int yVal, int[][] heightMap){
        if (xVal == 100 || xVal == -1){
            return 0;
        }
        if (yVal == 100 || yVal == -1){
            return 0;
        }
        int curHeight = heightMap[yVal][xVal];
        if (curHeight == 9){
            return 0;
        }
        heightMap[yVal][xVal] = 9;
        return 1 + countFills(xVal+1, yVal, heightMap) + countFills(xVal-1, yVal, heightMap) + countFills(xVal, yVal+1, heightMap) + countFills(xVal, yVal-1, heightMap);
    }
}
