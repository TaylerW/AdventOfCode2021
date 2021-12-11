package Star_13_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day7 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_13_14/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        ArrayList<Integer> crabPositions = new ArrayList<>();

        String[] numStr = sc.nextLine().split(",");
        sc.close();

        for (String num : numStr){
            crabPositions.add(Integer.parseInt(num));
        }
        
        Collections.sort(crabPositions);

        double bestHorizontal;
        if (crabPositions.size() % 2 == 0){
            bestHorizontal = (crabPositions.get(crabPositions.size() / 2) + crabPositions.get((crabPositions.size() / 2) - 1)) / 2.0;
        }
        else {
            bestHorizontal = crabPositions.get(crabPositions.size() / 2);
        }

        System.out.println("PART 1 : Best Horizontal value is " + bestHorizontal);

        int fuelCost = 0;
        for (int i = 0; i < crabPositions.size(); i++){
            fuelCost += Math.abs(crabPositions.get(i) - bestHorizontal);
        }
        System.out.println("PART 1 : Fuel cost: " + fuelCost);


        long sumOfPos = 0;
        for (int i = 0; i < crabPositions.size(); i++){
            sumOfPos += crabPositions.get(i);
        }
        System.out.println("PART 2 : Sum is " + sumOfPos);
        double avgPos = Math.floor(sumOfPos / (double)crabPositions.size());
        System.out.println("PART 2 : Best Horizontal value is " + avgPos);

        long fuelCost2 = 0;
        for (int i = 0; i < crabPositions.size(); i++){
            double curDiff = 0;
            for (int j = 1; j <= Math.abs(crabPositions.get(i) - avgPos); j++){
                curDiff += j;
            }
            fuelCost2 += curDiff;
        }
        System.out.println("PART 2 : Fuel Cost: " + fuelCost2);
    }
}