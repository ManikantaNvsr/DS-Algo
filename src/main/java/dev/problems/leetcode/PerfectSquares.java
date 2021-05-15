package dev.problems.leetcode;

// LeetCode: 279
// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(10));
        System.out.println(perfectSquares.numSquares(13));
        System.out.println(perfectSquares.numSquares(12));
        System.out.println(perfectSquares.numSquares(43));
    }

    public int numSquares(int n) {
        if (n == 0)
            return 0;
        if ((Math.sqrt(n)) % 1 == 0.0) {
            return 1;
        }
        // This problem needs DP approach since we need to evaluate all the possible minimum combinations
        // It is better to evaluate it from smaller problems and reach the n
        int[] arr = new int[n + 1];
        arr[0] = 0;
        // iteration for the each element until n
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // iteration to find the least possible squares need to represent i
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, arr[i - j * j] + 1);
            }
            arr[i] = min;
        }
        return arr[n];
    }
}
