package Star_23_24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day12{
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("Star_23_24/input.txt"); 
        Scanner sc = new Scanner(inputFile);

        // step 1, populate paths hashmap
        HashMap<String, ArrayList<String>> paths = new HashMap<>();
        while (sc.hasNextLine()){
            String[] endpoints = sc.nextLine().split("-");

            // Add endpoints to hashmap in both directions
            ArrayList<String> updatedList1 = paths.get(endpoints[0]);
            if (updatedList1 == null){
                updatedList1 = new ArrayList<>();
            }
            updatedList1.add(endpoints[1]);
            paths.put(endpoints[0], updatedList1);

            ArrayList<String> updatedList2 = paths.get(endpoints[1]);
            if (updatedList2 == null){
                updatedList2 = new ArrayList<>();
            }
            updatedList2.add(endpoints[0]);
            paths.put(endpoints[1], updatedList2);
        }

        // step 2, recurse through all nodes to count # of paths
        ArrayList<String> visitedNodes = new ArrayList<>();
        visitedNodes.add("start");

        int numOfPaths1 = countPaths1(visitedNodes, "start", paths);
        System.out.println("PART 1 : Result : " + numOfPaths1);

        long numOfPaths2 = countPaths2(visitedNodes, "start", paths, "");
        System.out.println("PART 2 : Result : " + numOfPaths2);
    }

    public static long countPaths2(ArrayList<String> visitedNodes, String currentNode, HashMap<String, ArrayList<String>> paths, String doubleDipCave){
        long retRes = 0;
        ArrayList<String> updatedList;

        for (String endpoint : paths.get(currentNode)){
            String doublyVisited = doubleDipCave;
            if (endpoint.equals("end")){
                retRes++;
            }
            else if ((!visitedNodes.contains(endpoint) || doubleDipCave.equals("")) && !endpoint.equals("start")){
                // recurse on this node
                updatedList = new ArrayList<>(visitedNodes); // shallow copy of parent traversal tree
                // determine if big cave or little cave
                char caveSizeMarker = endpoint.charAt(0);
                if (caveSizeMarker >= 97 && caveSizeMarker <= 122){
                    updatedList.add(endpoint);
                    if (visitedNodes.contains(endpoint)){
                        doublyVisited = new String(endpoint);
                    }
                }
                retRes += countPaths2(updatedList, endpoint, paths, doublyVisited);
            }
        }
        return retRes;
    }

    public static int countPaths1(ArrayList<String> visitedNodes, String currentNode, HashMap<String, ArrayList<String>> paths){
        int retRes = 0;
        ArrayList<String> updatedList;
        for (String endpoint : paths.get(currentNode)){
            if (endpoint.equals("end")){
                retRes++;
            }
            else if (!visitedNodes.contains(endpoint) && !endpoint.equals("start")){
                // recurse on this node
                updatedList = new ArrayList<>(visitedNodes); // shallow copy of parent traversal tree
                // determine if big cave or little cave
                char caveSizeMarker = endpoint.charAt(0);
                if (caveSizeMarker >= 97 && caveSizeMarker <= 122){
                    updatedList.add(endpoint);
                }
                retRes += countPaths1(updatedList, endpoint, paths);
            }
        }
        return retRes;
    }
}