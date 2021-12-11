package Star_19_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class day10 {
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_19_20/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        // PART 1
        // int currentScore = 0;
        // while (sc.hasNextLine()){
        //     char[] curLine = sc.nextLine().toCharArray();
        //     Stack<Character> stack = new Stack<>();
        //     for (char curChar : curLine){
        //         if (curChar == '(' || curChar == '{' || curChar == '[' || curChar == '<'){
        //             stack.push(curChar);
        //         }
        //         else {
        //             if (curChar == ')' && stack.peek() != '('){
        //                 currentScore += 3;
        //                 break;
        //             }
        //             else if (curChar == '}' && stack.peek() != '{'){
        //                 currentScore += 1197;
        //                 break;
        //             }
        //             else if (curChar == ']' && stack.peek() != '['){
        //                 currentScore += 57;
        //                 break;
        //             }
        //             else if (curChar == '>' && stack.peek() != '<'){
        //                 currentScore += 25137;
        //                 break;
        //             }
        //             else {
        //                 stack.pop();
        //             }
        //         }
        //     }
        // }
        // sc.close();
        // System.out.println("PART 1 : Result: " + currentScore);

        // PART 2
        ArrayList<Long> scoreBoard = new ArrayList<>();
        while (sc.hasNextLine()){
            long currentScore = 0;
            String curLineStr = sc.nextLine();
            char[] curLine = curLineStr.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean corruptLine = false;
            for (char curChar : curLine){
                if (curChar == '(' || curChar == '{' || curChar == '[' || curChar == '<'){
                    stack.push(curChar);
                }
                else {
                    if (curChar == ')' && stack.peek() != '('){
                        corruptLine = true;
                        break;
                    }
                    else if (curChar == '}' && stack.peek() != '{'){
                        corruptLine = true;
                        break;
                    }
                    else if (curChar == ']' && stack.peek() != '['){
                        corruptLine = true;
                        break;
                    }
                    else if (curChar == '>' && stack.peek() != '<'){
                        corruptLine = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if (!corruptLine){
                int stackSize = stack.size();
                for (int i = 0; i < stackSize; i++){
                    currentScore *= 5;
                    char curChar = stack.pop();
                    if (curChar == '('){
                        currentScore += 1;
                    }
                    else if (curChar == '{'){
                        currentScore += 3;
                    }
                    else if (curChar == '['){
                        currentScore += 2;
                    }
                    else if (curChar == '<'){
                        currentScore += 4;
                    }
                }
                scoreBoard.add(currentScore);
            }
        }
        sc.close();
        Collections.sort(scoreBoard);

        System.out.println("PART 2 : Result: " + scoreBoard.get(scoreBoard.size() / 2));
    }
}
