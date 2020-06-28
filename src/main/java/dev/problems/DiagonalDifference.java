package dev.problems;

import java.util.List;

// https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        int length  = arr.size();

        // calculate the diagonal sum which starts at (0,0)
        for (int i = 0; i < length; i++) {

            leftDiagonalSum += arr.get(i).get(i);

        }

        // calculate the diagonal sum which starts at (0,2)
        for (int i = 0; i < length; i++) {
            rightDiagonalSum += arr.get(i).get(length - i-1);
        }

        return Math.abs(rightDiagonalSum - leftDiagonalSum);
    }
}
