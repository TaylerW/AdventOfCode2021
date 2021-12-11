package Star_5_6;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {

    public static void main(String[] args) throws FileNotFoundException{

        // PART 1 ------------------------------------------------------------------
        File inputFile1 = new File("Star_5_6/input.txt");
        Scanner sc1 = new Scanner(inputFile1);

        StringBuilder gammaBinaryString1 = new StringBuilder();
        StringBuilder epsilonBinaryString1 = new StringBuilder();
        
        int[] oneCounters1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] zeroCounters1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (sc1.hasNextLine()){
            char[] lineBits = sc1.nextLine().toCharArray();
            for (int i = 0; i < 12; i++){
                if (lineBits[i] == '1'){
                    oneCounters1[i]++;
                }
                else {
                    zeroCounters1[i]++;
                }
            }
        }

        sc1.close();

        for (int i = 0; i < 12; i++){
            if (oneCounters1[i] > zeroCounters1[i]){
                gammaBinaryString1.append('1');
                epsilonBinaryString1.append('0');
            }
            else {
                gammaBinaryString1.append('0');
                epsilonBinaryString1.append('1');
            }
        }

        System.out.println("gamma binary is " + gammaBinaryString1);
        System.out.println("epsilon binary is " + epsilonBinaryString1);

        int gamma1 = Integer.parseInt(gammaBinaryString1.toString(), 2);
        int epsilon1 = Integer.parseInt(epsilonBinaryString1.toString(), 2);

        System.out.println("gamma value is " + gamma1);
        System.out.println("epsilon value is " + epsilon1);
        System.out.println("Result: " + gamma1 * epsilon1);
        // PART 1 ------------------------------------------------------------------

        // PART 2 ------------------------------------------------------------------
        // Init File and Scanner
        File inputFile2 = new File("Star_5_6/input.txt");
        Scanner sc2 = new Scanner(inputFile2);

        // ArrayLists to store potential values for OGR and C02SR
        ArrayList<char[]> potentialOGRNums = new ArrayList<>();
        ArrayList<char[]> potentialC02SRNums = new ArrayList<>();

        // Counters for 1's and 0's
        int[] oneCounters2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] oneCounters22 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] zeroCounters2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] zeroCounters22 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // Read all data from file, increment counters, add string arrays to both ArrayLists
        while (sc2.hasNextLine()){
            char[] lineBits = sc2.nextLine().toCharArray();
            for (int i = 0; i < 12; i++){
                if (lineBits[i] == '1'){
                    oneCounters2[i]++;
                    oneCounters22[i]++;
                }
                else {
                    zeroCounters2[i]++;
                    zeroCounters22[i]++;
                }
            }
            potentialC02SRNums.add(lineBits);
            potentialOGRNums.add(lineBits);
        }

        sc2.close();

        // Iterate through every bit position
        for (int i = 0; i < 12; i++){
            // 0 is most common
            if (zeroCounters2[i] > oneCounters2[i]){
                // remove all bit arrays starting with '1'
                for (int j = 0; j < potentialOGRNums.size(); j++){
                    if (potentialOGRNums.get(j)[i] != '0'){
                        for (int k = 0; k < 12; k++){
                            if (potentialOGRNums.get(j)[k] == '1'){
                                oneCounters2[k]--;
                            }
                            else {
                                zeroCounters2[k]--;
                            }
                        }
                        potentialOGRNums.remove(j);
                        j--;
                    }
                }
            }
            // 1 is most common or preferred
            else {
                // remove all bit arrays starting with '0'
                for (int j = 0; j < potentialOGRNums.size(); j++){
                    if (potentialOGRNums.get(j)[i] != '1'){
                        for (int k = 0; k < 12; k++){
                            if (potentialOGRNums.get(j)[k] == '1'){
                                oneCounters2[k]--;
                            }
                            else {
                                zeroCounters2[k]--;
                            }
                        }
                        potentialOGRNums.remove(j);
                        j--;
                    }
                }
            }
            // Break if only 1 bit array remains
            if (potentialOGRNums.size() == 1){
                break;
            }
        }

        // Iterate through every bit position
        for (int i = 0; i < 12; i++){
            // 1 is the least common
            if (oneCounters22[i] < zeroCounters22[i]){
                // remove all bit arrays starting with '1'
                for (int j = 0; j < potentialC02SRNums.size(); j++){
                    if (potentialC02SRNums.get(j)[i] != '1'){
                        for (int k = 0; k < 12; k++){
                            if (potentialC02SRNums.get(j)[k] == '1'){
                                oneCounters22[k]--;
                            }
                            else {
                                zeroCounters22[k]--;
                            }
                        }
                        potentialC02SRNums.remove(j);
                        j--;
                    }
                }
            }
            // 0 is least common or preferred
            else {
                // remove all bit arrays starting with '0'
                for (int j = 0; j < potentialC02SRNums.size(); j++){
                    if (potentialC02SRNums.get(j)[i] != '0'){
                        for (int k = 0; k < 12; k++){
                            if (potentialC02SRNums.get(j)[k] == '1'){
                                oneCounters22[k]--;
                            }
                            else {
                                zeroCounters22[k]--;
                            }
                        }
                        potentialC02SRNums.remove(j);
                        j--;
                    }
                }
            }
            // Break if only 1 bit array remains
            if (potentialC02SRNums.size() == 1){
                break;
            }
        }

        StringBuilder OGRStr = new StringBuilder();
        for (char bit : potentialOGRNums.get(0)){
            OGRStr.append(bit);
        }

        StringBuilder C02SRStr = new StringBuilder();
        for (char bit : potentialC02SRNums.get(0)){
            C02SRStr.append(bit);
        }

        int OGRNum = Integer.parseInt(OGRStr.toString(), 2);
        int C02SRNum = Integer.parseInt(C02SRStr.toString(), 2);

        System.out.println("OGRNum : " + OGRNum);
        System.out.println("C02SRNum : " + C02SRNum);
        System.out.println("Result: " + OGRNum * C02SRNum);
        // PART 2 ------------------------------------------------------------------
    }
    
}
