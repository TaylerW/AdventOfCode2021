package Star_3_4;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException{
        
        // PART 1 ----------------------------------------------------------
        File inputFile1 = new File("Star_3_4/input.txt");
        Scanner sc1 = new Scanner(inputFile1);

        int horizontalPos1 = 0;
        int depth1 = 0;

        while (sc1.hasNextLine()){
            String[] curLine = sc1.nextLine().split(" ");

            String commandType = curLine[0];
            int commandValue = Integer.parseInt(curLine[1]);

            if (commandType.equals("forward")){
                horizontalPos1 += commandValue;
            }
            else if (commandType.equals("up")){
                depth1 -= commandValue;
            }
            else if (commandType.equals("down")){
                depth1 += commandValue;
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
        sc1.close();
        System.out.println("HorizontalPos = " + horizontalPos1);
        System.out.println("Depth = " + depth1);
        System.out.println("Result = " + horizontalPos1 * depth1);
        // PART 1 ----------------------------------------------------------

        // PART 2 ----------------------------------------------------------
        File inputFile2 = new File("Star_3_4/input.txt");
        Scanner sc2 = new Scanner(inputFile2);

        int horizontalPos2 = 0;
        int depth2 = 0;
        int aim = 0;

        while (sc2.hasNextLine()){
            String[] curLine = sc2.nextLine().split(" ");

            String commandType = curLine[0];
            int commandValue = Integer.parseInt(curLine[1]);

            if (commandType.equals("forward")){
                horizontalPos2 += commandValue;
                depth2 += aim * commandValue;
            }
            else if (commandType.equals("up")){
                aim -= commandValue;
            }
            else if (commandType.equals("down")){
                aim += commandValue;
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
        sc2.close();
        System.out.println("HorizontalPos = " + horizontalPos2);
        System.out.println("Depth = " + depth2);
        System.out.println("Result = " + horizontalPos2 * depth2);
        // PART 2 ----------------------------------------------------------
    }
}