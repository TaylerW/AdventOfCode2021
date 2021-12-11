package Star_15_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day8 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_15_16/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        int total = 0;

        // do this for all lines in input file
        while (sc.hasNextLine()){
            String curLine = sc.nextLine();
            System.out.println("Analyzing line: " + curLine);
            String[] lineParts = curLine.split(" \\| ", 2);

            String[] inputPart = lineParts[0].split(" ");
            String[] outputPart = lineParts[1].split(" ");

            HashMap<String, ArrayList<Character>> structures = new HashMap<>();
            ArrayList<String> encodedDigits = new ArrayList<>();

            for (String token : inputPart){
                encodedDigits.add(token);
            }

            String oneStructure = "";
            String sevenStructure = "";
            String fourStructure = "";
            String eightStructure = "";

            for (int i = 0; i < encodedDigits.size(); i++){
                // find and remove all 1's
                if (encodedDigits.get(i).length() == 2){
                    oneStructure = encodedDigits.get(i);
                    encodedDigits.remove(i--);
                }
                // find and remove all 7's
                else if (encodedDigits.get(i).length() == 3){
                    sevenStructure = encodedDigits.get(i);
                    encodedDigits.remove(i--);
                }
                // find and remove all 4's
                else if (encodedDigits.get(i).length() == 4){
                    fourStructure = encodedDigits.get(i);
                    encodedDigits.remove(i--);
                }
                // find and remove all 8's
                else if (encodedDigits.get(i).length() == 7){
                    eightStructure = encodedDigits.get(i);
                    encodedDigits.remove(i--);
                }
            }

            System.out.println("Remaining Encoded Strings: " + encodedDigits);

            structures.put("Zero", new ArrayList<>());

            structures.put("One", new ArrayList<>());
            for (Character ch : oneStructure.toCharArray()){
                structures.get("One").add(ch);
            }

            structures.put("Two", new ArrayList<>());
            structures.put("Three", new ArrayList<>());

            structures.put("Four", new ArrayList<>());
            for (Character ch : fourStructure.toCharArray()){
                structures.get("Four").add(ch);
            }

            structures.put("FourDiff", new ArrayList<>());
            for (Character ch : fourStructure.toCharArray()){
                if (!structures.get("One").contains(ch)){
                    structures.get("FourDiff").add(ch);
                }
            }

            System.out.println("FourDiff: " + structures.get("FourDiff"));

            structures.put("Five", new ArrayList<>());
            structures.put("Six", new ArrayList<>());

            structures.put("Seven", new ArrayList<>());
            for (Character ch : sevenStructure.toCharArray()){
                structures.get("Seven").add(ch);
            }
            structures.put("Eight", new ArrayList<>());
            for (Character ch : eightStructure.toCharArray()){
                structures.get("Eight").add(ch);
            }

            structures.put("Nine", new ArrayList<>());

            // only options left are of length 5 and 6
            for (int i = 0; i < encodedDigits.size(); i++){
                
                ArrayList<Character> curArr = new ArrayList<>();
                String curStr = encodedDigits.get(i);
                System.out.println("Looking at " + curStr);
                for (Character ch : curStr.toCharArray()){
                    curArr.add(ch);
                }
                // 2, 3, or 5
                if (curStr.length() == 5){
                    // this is 3
                    if (curArr.contains(structures.get("One").get(0)) && curArr.contains(structures.get("One").get(1))){
                        System.out.println("This is the digit 3");
                        if (structures.get("Three").size() == 0){
                           for (Character ch : curArr){
                                structures.get("Three").add(ch);
                            }   
                        }
                        encodedDigits.remove(i--);
                    }
                    else if (curArr.contains(structures.get("FourDiff").get(0)) && curArr.contains(structures.get("FourDiff").get(1))){
                        System.out.println("This is the digit 5");
                        if (structures.get("Five").size() == 0){
                            for (Character ch : curArr){
                                structures.get("Five").add(ch);
                            }
                        }
                        encodedDigits.remove(i--);
                    }
                    else {
                        System.out.println("This is the digit 2");
                        if (structures.get("Two").size() == 0){
                            for (Character ch : curArr){
                                structures.get("Two").add(ch);
                            }
                        }
                        encodedDigits.remove(i--);
                    }
                }
                // 0, 6, or 9
                else {
                    if (curArr.contains(structures.get("Four").get(0)) && curArr.contains(structures.get("Four").get(1)) && curArr.contains(structures.get("Four").get(2)) && curArr.contains(structures.get("Four").get(3))){
                        System.out.println("This is the digit 9");
                        for (Character ch : curArr){
                            structures.get("Nine").add(ch);
                        }
                        encodedDigits.remove(i--);
                    }
                    else if (curArr.contains(structures.get("FourDiff").get(0)) && curArr.contains(structures.get("FourDiff").get(1))){
                        System.out.println("This is the digit 6");
                        for (Character ch : curArr){
                            structures.get("Six").add(ch);
                        }
                        encodedDigits.remove(i--);
                    }
                    else {
                        System.out.println("This is the digit 0");
                        for (Character ch : curArr){
                            structures.get("Zero").add(ch);
                        }
                        encodedDigits.remove(i--);
                    }
                }
            }

            System.out.println("Zero contains the characters " + structures.get("Zero"));
            System.out.println("One contains the characters " + structures.get("One"));
            System.out.println("Two contains the characters " + structures.get("Two"));
            System.out.println("Three contains the characters " + structures.get("Three"));
            System.out.println("Four contains the characters " + structures.get("Four"));
            System.out.println("FourDiff contains the characters " + structures.get("FourDiff"));
            System.out.println("Five contains the characters " + structures.get("Five"));
            System.out.println("Six contains the characters " + structures.get("Six"));
            System.out.println("Seven contains the characters " + structures.get("Seven"));
            System.out.println("Eight contains the characters " + structures.get("Eight"));

            System.out.println();

            String outputStr = "";
            for (String encodedOutPutDigit : outputPart){
                System.out.println("Looking at part " + encodedOutPutDigit);
                if (encodedOutPutDigit.length() == 2){
                    System.out.println("This is a 1");
                    outputStr += "1";
                }
                else if (encodedOutPutDigit.length() == 3){
                    System.out.println("This is a 7");
                    outputStr += "7";
                }
                else if (encodedOutPutDigit.length() == 4){
                    System.out.println("This is a 4");
                    outputStr += "4";
                }
                else if (encodedOutPutDigit.length() == 7){
                    System.out.println("This is an 8");
                    outputStr += "8";
                }
                else if (encodedOutPutDigit.length() == 5){
                    char[] curChArr = encodedOutPutDigit.toCharArray();
                    if (structures.get("Two").contains(curChArr[0]) && structures.get("Two").contains(curChArr[1]) && structures.get("Two").contains(curChArr[2]) && structures.get("Two").contains(curChArr[3]) && structures.get("Two").contains(curChArr[4])){
                        System.out.println("This is a 2");
                        outputStr += "2";
                    }
                    else if (structures.get("Three").contains(curChArr[0]) && structures.get("Three").contains(curChArr[1]) && structures.get("Three").contains(curChArr[2]) && structures.get("Three").contains(curChArr[3]) && structures.get("Three").contains(curChArr[4])){
                        System.out.println("This is a 3");
                        outputStr += "3";
                    }
                    if (structures.get("Five").contains(curChArr[0]) && structures.get("Five").contains(curChArr[1]) && structures.get("Five").contains(curChArr[2]) && structures.get("Five").contains(curChArr[3]) && structures.get("Five").contains(curChArr[4])){
                        System.out.println("This is a 5");
                        outputStr += "5";
                    }
                }
                else {
                    char[] curChArr = encodedOutPutDigit.toCharArray();
                    if (structures.get("Zero").contains(curChArr[0]) && structures.get("Zero").contains(curChArr[1]) && structures.get("Zero").contains(curChArr[2]) && structures.get("Zero").contains(curChArr[3]) && structures.get("Zero").contains(curChArr[4]) && structures.get("Zero").contains(curChArr[5])){
                        System.out.println("This is a 0");
                        outputStr += "0";
                    }
                    else if (structures.get("Six").contains(curChArr[0]) && structures.get("Six").contains(curChArr[1]) && structures.get("Six").contains(curChArr[2]) && structures.get("Six").contains(curChArr[3]) && structures.get("Six").contains(curChArr[4]) && structures.get("Six").contains(curChArr[5])){
                        System.out.println("This is a 6");
                        outputStr += "6";
                    }
                    else if (structures.get("Nine").contains(curChArr[0]) && structures.get("Nine").contains(curChArr[1]) && structures.get("Nine").contains(curChArr[2]) && structures.get("Nine").contains(curChArr[3]) && structures.get("Nine").contains(curChArr[4]) && structures.get("Nine").contains(curChArr[5])){
                        System.out.println("This is a 9");
                        outputStr += "9";
                    }
                }
            }

            System.out.println("This line's output: " + outputStr);
            total += Integer.parseInt(outputStr);

            System.out.println();
            System.out.println();

            
        }
        sc.close();

        System.out.println("Result: " + total);
    }
}
