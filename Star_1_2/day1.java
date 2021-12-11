package Star_1_2;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class day1{
    public static void main(String[] args) throws FileNotFoundException{
        // PART 1 ----------------------------------------------------------
        int numOfInc1 = 0;
        File inputFile1 = new File("Star_1_2/input.txt");
        Scanner sc1 = new Scanner(inputFile1);

        int prevNum = Integer.parseInt(sc1.nextLine());

        while (sc1.hasNextLine()){
            int curNum = Integer.parseInt(sc1.nextLine());
            if (curNum > prevNum){
                numOfInc1++;
            }
            prevNum = curNum;
        }
        sc1.close();
        System.out.println("Number of Increases: " + numOfInc1);
        // PART 1 ----------------------------------------------------------

        // PART 2 ----------------------------------------------------------
        int numOfInc2 = 0;
        File inputFile2 = new File("Star_1_2/input.txt");
        Scanner sc2 = new Scanner(inputFile2);

        int prevNum1 = Integer.parseInt(sc2.nextLine());
        int prevNum2 = Integer.parseInt(sc2.nextLine());
        int prevNum3 = Integer.parseInt(sc2.nextLine());
        
        int prevSum = prevNum1 + prevNum2 + prevNum3;

        while (sc2.hasNextLine()){
            int curNum = Integer.parseInt(sc2.nextLine());
            int curSum = curNum + prevNum2 + prevNum3;
            if (curSum > prevSum){
                numOfInc2++;
            }
            prevNum1 = prevNum2;
            prevNum2 = prevNum3;
            prevNum3 = curNum;
            prevSum = curSum;
        }
        sc2.close();
        System.out.println("Number of Increases: " + numOfInc2);
        // PART 2 ----------------------------------------------------------
    }
}