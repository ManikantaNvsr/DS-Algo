package dev.problems;

// https://www.hackerrank.com/challenges/plus-minus/problem
public class PlusMinus {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,-1,0,-1};
        plusMinus(arr);
    }

    static void plusMinus(int[] arr) {
        double positiveValues = 0.000000;
        double negativeValues = 0.000000;
        double zeroValues = 0.000000;
        int length = arr.length;
        for (int value : arr) {
            if (value > 0) {
                positiveValues++;
            } else if (value < 0) {
                negativeValues++;
            } else {
                zeroValues++;
            }
        }
        System.out.printf("%.6f %n", positiveValues/length);
        System.out.printf("%.6f %n", negativeValues/length);
        System.out.printf("%.6f %n", zeroValues/length);
    }

}
