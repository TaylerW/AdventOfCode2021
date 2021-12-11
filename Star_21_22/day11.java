package Star_21_22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day11 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_21_22/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        int[][] octopusPower = new int[10][10];

        // Populate initial array
        int curLineIndex = 0;
        while (sc.hasNextLine()){
            String[] curLineStr = sc.nextLine().split("");
            for (int i = 0; i < 10; i++){
                octopusPower[curLineIndex][i] = Integer.parseInt(curLineStr[i]);
            }
            curLineIndex++;
        }
        sc.close();

        boolean allSync = false;
        int stepCount = 0;
        while (!allSync){
            int numOfFlashesThisStep = 0;
            stepCount++;
            // Step 1, increment all values by 1
            for (int j = 0; j < 10; j++){
                for (int k = 0; k < 10; k++){
                    octopusPower[j][k]++;
                }
            }

            // step 2, flash if fully powered
            for (int j = 0; j < 10; j++){
                for (int k = 0; k < 10; k++){
                    if (octopusPower[j][k] >= 10){
                        numOfFlashesThisStep = 1 + flashOctopus(j, k, octopusPower);
                        if (numOfFlashesThisStep == 100){
                            allSync = true;
                        }
                    }
                }
            }
        }
        System.out.println("PART 2 : Result: " + stepCount);
    }

    public static int flashOctopus(int i, int j, int[][] octopusArr){
        octopusArr[i][j] = 0;
        // top left
        int retRes = 0;
        if (i - 1 >= 0 && j - 1 >= 0){
            if (octopusArr[i-1][j-1] != 0){
                octopusArr[i-1][j-1]++;
                if (octopusArr[i-1][j-1] >= 10){
                    retRes += 1 + flashOctopus(i-1, j-1, octopusArr);
                }
            }
        }
        // straight above
        if (i-1 >= 0){
            if (octopusArr[i-1][j] != 0){
                octopusArr[i-1][j]++;
                if (octopusArr[i-1][j] >= 10){
                    retRes += 1 + flashOctopus(i-1, j, octopusArr);
                }
            }
        }
        // top right
        if (i - 1 >= 0 && j + 1 < 10){
            if (octopusArr[i-1][j+1] != 0){
                octopusArr[i-1][j+1]++;
                if (octopusArr[i-1][j+1] >= 10){
                    retRes += 1 + flashOctopus(i-1, j+1, octopusArr);
                }
            }
        }
        // right
        if (j + 1 < 10){
            if (octopusArr[i][j+1] != 0){
                octopusArr[i][j+1]++;
                if (octopusArr[i][j+1] >= 10){
                    retRes += 1 + flashOctopus(i, j+1, octopusArr);
                }
            }
        }
        // bottom right
        if (i + 1 < 10 && j + 1 < 10){
            if (octopusArr[i+1][j+1] != 0){
                octopusArr[i+1][j+1]++;
                if (octopusArr[i+1][j+1] >= 10){
                    retRes += 1 + flashOctopus(i+1, j+1, octopusArr);
                }
            }
        }
        // below
        if (i + 1 < 10){
            if (octopusArr[i+1][j] != 0){
                octopusArr[i+1][j]++;
                if (octopusArr[i+1][j] >= 10){
                    retRes += 1 + flashOctopus(i+1, j, octopusArr);
                }
            }
        }
        // bottom left
        if (i + 1 < 10 && j - 1 >= 0){
            if (octopusArr[i+1][j-1] != 0){
                octopusArr[i+1][j-1]++;
                if (octopusArr[i+1][j-1] >= 10){
                    retRes += 1 + flashOctopus(i+1, j-1, octopusArr);
                }
            }
        }
        // left
        if (j - 1 >= 0){
            if (octopusArr[i][j-1] != 0){
                octopusArr[i][j-1]++;
                if (octopusArr[i][j-1] >= 10){
                    retRes += 1 + flashOctopus(i, j-1, octopusArr);
                }
            }
        }

        return retRes;
    }
}
