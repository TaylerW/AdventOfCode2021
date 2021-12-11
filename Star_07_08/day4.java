package Star_7_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) throws FileNotFoundException{
        /* PART 1
        // Set up file and scanner
        File inputFile1 = new File("Star_7_8/input.txt");
        Scanner sc1 = new Scanner(inputFile1);

        // Board ArrayList
        ArrayList<int[][]> boards = new ArrayList<>();
        
        String[] numsDrawnArr = sc1.nextLine().split(",");      // holds nums drawn as strings
        int[] numsDrawn = new int[numsDrawnArr.length];         // holds nums drawn as ints

        // Populate numsDrawn array
        for (int i = 0; i < numsDrawnArr.length; i++){
            numsDrawn[i] = Integer.parseInt(numsDrawnArr[i]);
        }

        // Populate boards arraylist
        while (sc1.hasNextLine()){
            sc1.nextLine(); // skip newline between boards

            int[][] curBoard = new int[5][5]; // new board

            // Read every row of the board
            for (int i = 0; i < 5; i++){
                ArrayList<String> curRow = new ArrayList<>();
                String[] curLine = sc1.nextLine().split(" ");

                for (int k = 0; k < curLine.length; k++){
                    if (!curLine[k].strip().equals("")){
                        curRow.add(curLine[k].strip());
                    }
                }

                for (int j = 0; j < 5; j++){
                    curBoard[i][j] = Integer.parseInt(curRow.get(j));
                }
            }
            boards.add(curBoard); // add board to boards arraylist
        }
        sc1.close();

        // At this point:
        // -- boards (ArrayList<int[][]>) holds all boards in input
        // -- numsDrawn (int[]) holds all numbers to be drawn

        boolean winnerBoardFound = false;
        int winningBoard = -1;
        int winningNumber = -1;
        boolean markMade = false;
        // Read all numbers, mark associated boards
        for (int i = 0; i < numsDrawn.length; i++){
            int curNum = numsDrawn[i];
            // Go through every board
            for (int j = 0; j < boards.size(); j++){
                // Go through every row
                for (int k = 0; k < 5; k++){
                    // Go through every column
                    for (int m = 0; m < 5; m++){
                        if (boards.get(j)[k][m] == curNum){
                            boards.get(j)[k][m] = -1; // -1 signifies the spot is marked
                            markMade = true;
                        }
                        if (markMade){
                            // check for win conditions
                            winnerBoardFound = checkForWin(boards.get(j));
                            markMade = false;
                        }
                        if (winnerBoardFound){
                            winningBoard = j;
                            winningNumber = curNum;
                            break;
                        }
                    }
                    if (winnerBoardFound){
                        break;
                    }
                }
                if (winnerBoardFound){
                    break;
                }
            }
            if (winnerBoardFound){
                break;
            }
        }

        if (winnerBoardFound){
            // calculate answer
            System.out.println("A WINNER WAS FOUND");

            // At this point:
            // -- the winning board is known
            // -- the winning number is known
            int curSum = 0;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    if (boards.get(winningBoard)[i][j] != -1){
                        curSum += boards.get(winningBoard)[i][j];
                    }
                }
            }
            System.out.println("curSum = " + curSum);
            System.out.println("Result: " + curSum * winningNumber);

        }*/

        // PART 2
        // Set up file and scanner
        File inputFile1 = new File("Star_7_8/input.txt");
        Scanner sc1 = new Scanner(inputFile1);

        // Board ArrayList
        ArrayList<int[][]> boards = new ArrayList<>();
        
        String[] numsDrawnArr = sc1.nextLine().split(",");      // holds nums drawn as strings
        int[] numsDrawn = new int[numsDrawnArr.length];         // holds nums drawn as ints

        // Populate numsDrawn array
        for (int i = 0; i < numsDrawnArr.length; i++){
            numsDrawn[i] = Integer.parseInt(numsDrawnArr[i]);
        }

        // Populate boards arraylist
        while (sc1.hasNextLine()){
            sc1.nextLine(); // skip newline between boards

            int[][] curBoard = new int[5][5]; // new board

            // Read every row of the board
            for (int i = 0; i < 5; i++){
                ArrayList<String> curRow = new ArrayList<>();
                String[] curLine = sc1.nextLine().split(" ");

                for (int k = 0; k < curLine.length; k++){
                    if (!curLine[k].strip().equals("")){
                        curRow.add(curLine[k].strip());
                    }
                }

                for (int j = 0; j < 5; j++){
                    curBoard[i][j] = Integer.parseInt(curRow.get(j));
                }
            }
            boards.add(curBoard); // add board to boards arraylist
        }
        sc1.close();

        // At this point:
        // -- boards (ArrayList<int[][]>) holds all boards in input
        // -- numsDrawn (int[]) holds all numbers to be drawn

        boolean lastWinnerBoardFound = false;
        int lastWinningBoard = -1;
        int winningNumber = -1;
        int numOfWinningBoards = 0;
        boolean markMade = false;
        // Read all numbers, mark associated boards
        for (int i = 0; i < numsDrawn.length; i++){
            int curNum = numsDrawn[i];
            // Go through every board
            for (int j = 0; j < boards.size(); j++){
                // Go through every row
                for (int k = 0; k < 5; k++){
                    // Go through every column
                    for (int m = 0; m < 5; m++){
                        if (boards.get(j)[k][m] == curNum){
                            boards.get(j)[k][m] = -1; // -1 signifies the spot is marked
                            markMade = true;
                        }
                        if (markMade){
                            // check for win conditions
                            boolean winnerBoardFound = checkForWin(boards.get(j));
                            if (winnerBoardFound){
                                numOfWinningBoards++;
                                if (numOfWinningBoards == boards.size()){
                                    lastWinnerBoardFound = true;
                                }
                                else {
                                    for (int h = 0; h < 5; h++){
                                        for (int g = 0; g < 5; g++){
                                            boards.get(j)[h][g] = -2; // invalidate winning board
                                        }
                                    }
                                }
                            }
                            markMade = false;
                        }
                        if (lastWinnerBoardFound){
                            System.out.println("Last board to win was " + j);
                            lastWinningBoard = j;
                            winningNumber = curNum;
                            break;
                        }
                    }
                    if (lastWinnerBoardFound){
                        break;
                    }
                }
                if (lastWinnerBoardFound){
                    break;
                }
            }
            if (lastWinnerBoardFound){
                break;
            }
        }

        if (lastWinnerBoardFound){
            // calculate answer
            System.out.println("THE LAST WINNER WAS FOUND");

            // At this point:
            // -- the winning board is known
            // -- the winning number is known
            int curSum = 0;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    if (boards.get(lastWinningBoard)[i][j] != -1){
                        curSum += boards.get(lastWinningBoard)[i][j];
                    }
                }
            }
            System.out.println("curSum = " + curSum);
            System.out.println("Result: " + curSum * winningNumber);

        }


    }

    public static boolean checkForWin(int[][] curBoard){
        // Check for row wins
        for (int i = 0; i < 5; i++){
            if (curBoard[i][0] == -1 
            && curBoard[i][1] == -1
            && curBoard[i][2] == -1
            && curBoard[i][3] == -1
            && curBoard[i][4] == -1){
                return true;
            }
        }

        // Check for column wins
        for (int i = 0; i < 5; i++){
            if (curBoard[0][i] == -1 
            && curBoard[1][i] == -1
            && curBoard[2][i] == -1
            && curBoard[3][i] == -1
            && curBoard[4][i] == -1){
                return true;
            }
        }

        return false;
    }
}
