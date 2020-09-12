package dev.problems.leetcode;

import java.util.ArrayList;

// https://leetcode.com/contest/weekly-contest-195/problems/path-crossing/
public class PathCrossing {

    public static void main(String[] args) {

//        String path = "WSSESEEE";
//        String path = "NSE";
//        String path = "NES";
//        String path = "NESW";
//        String path = "NESWW";
        String path = "NNSWWEWSSESSWENNW";
        PathCrossing pathCrossing = new PathCrossing();
        System.out.println(pathCrossing.isPathCrossing(path));
    }

    public boolean isPathCrossing(String path) {
        int leftIndex = 0;
        int rightIndex = 0;
        String[] directions = path.split("");

        ArrayList<String> points = new ArrayList<>();
        points.add(leftIndex +""+rightIndex);

        for (String direction : directions) {
            switch (direction) {
                case "N":
                    rightIndex++;
                    break;
                case "E":
                    leftIndex++;
                    break;
                case "S":
                    rightIndex--;
                    break;
                case "W":
                    leftIndex--;
                    break;
            }

            String point  = leftIndex +""+rightIndex;

            if(points.contains(point)){
                return true;
            }
            points.add(point);
        }
        return false;
    }
}
