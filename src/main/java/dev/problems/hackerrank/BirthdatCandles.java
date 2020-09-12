package dev.problems.hackerrank;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem
public class BirthdatCandles {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,3};
        System.out.println(birthdayCakeCandles(nums));
    }

    static int birthdayCakeCandles(int[] ar) {
        int maxheight = 0;
        int noOfCandlesCabBeBlownOut = 1;
        for (int height : ar) {
            if (maxheight > height) {
            } else {
                if (maxheight == height) {
                    noOfCandlesCabBeBlownOut++;
                } else {
                    maxheight = height;
                    noOfCandlesCabBeBlownOut = 1;
                }
            }


        }
        return noOfCandlesCabBeBlownOut;
    }

}
