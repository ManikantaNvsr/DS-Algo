package dev.problems;

import java.util.ArrayList;

// https://leetcode.com/problems/arranging-coins/
public class ArrangingCoins {

    public static void main(String[] args) {

        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(1804289383));

    }

    public int arrangeCoins(int n) {

        if (n != 0) {
            // efficient approach
            return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);

            /*// Naive Approach
            long sum = 0;
            int row;
            for(row=1; sum <= n; row++){
                sum += row;
                if(sum == n){
                    return row;
                }


            }

            return row-2;*/
        }

        return 0;
    }
}
