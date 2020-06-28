package dev.problems;
// https://www.hackerrank.com/challenges/a-very-big-sum/problem
public class VeryBigSum {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long each : ar){
            sum += each;
        }
        return sum;
    }
}
