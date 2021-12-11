package Star_11_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_11_12/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        final int NUM_OF_DAYS = 256;
        HashMap<Long, Long> lanternFish = new HashMap<Long, Long>(); // holds all nums
        
        lanternFish.put((long)0, (long)0);
        lanternFish.put((long)1, (long)0);
        lanternFish.put((long)2, (long)0);
        lanternFish.put((long)3, (long)0);
        lanternFish.put((long)4, (long)0);
        lanternFish.put((long)5, (long)0);
        lanternFish.put((long)6, (long)0);
        lanternFish.put((long)7, (long)0);
        lanternFish.put((long)8, (long)0);

        // Populate lanternFish arraylist with starting values
        for (String numStr : sc.nextLine().split(",")){
            long curNum = Long.parseLong(numStr);
            lanternFish.put((long)curNum, lanternFish.get(curNum) + 1); // O(1)
        }
        sc.close();

        for (int currentDay = 1; currentDay <= NUM_OF_DAYS; currentDay++){
            long fishToAdd = lanternFish.get((long)0);
            lanternFish.put((long)0, lanternFish.get((long)1));
            lanternFish.put((long)1, lanternFish.get((long)2));
            lanternFish.put((long)2, lanternFish.get((long)3));
            lanternFish.put((long)3, lanternFish.get((long)4));
            lanternFish.put((long)4, lanternFish.get((long)5));
            lanternFish.put((long)5, lanternFish.get((long)6));
            lanternFish.put((long)6, lanternFish.get((long)7) + fishToAdd);
            lanternFish.put((long)7, lanternFish.get((long)8));
            lanternFish.put((long)8, fishToAdd);
        }

        long sum = 0;
        for (int i = 0; i < 9; i++){
            sum += lanternFish.get((long)i);
        }
        System.out.println("Result: " + sum);
    }
}
