package dev.problems;

import java.nio.file.Path;

// https://leetcode.com/contest/weekly-contest-195/problems/path-crossing/
public class PathCrossing {

    public static void main(String[] args) {

        String path = "WSSESEEE";
//        String path = "NSE";
//        String path = "NES";
//        String path = "NESW";
        PathCrossing pathCrossing = new PathCrossing();
        System.out.println(pathCrossing.isPathCrossing(path));
    }

    public boolean isPathCrossing(String path) {
        String[] directions = path.split("");
        int offSet = 0;
        for (String direction :
                directions) {
            if (direction.equalsIgnoreCase("N")) {
                offSet += 1;
            } else if (direction.equalsIgnoreCase("S")) {
                offSet -= 1;
            } else if (direction.equalsIgnoreCase("W")) {
                offSet += 1000000000;
            } else {
                offSet -= 1000000000;
            }
            if (offSet == 0) {
                return true;
            }
        }

        return offSet == 0;
    }
}
