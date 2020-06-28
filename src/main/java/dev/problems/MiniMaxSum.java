package dev.problems;

import java.util.Arrays;

public class MiniMaxSum {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,4,5,3};
        miniMaxSum(nums);
    }

    static void miniMaxSum(int[] arr) {

        Arrays.sort(arr);
        long sum = 0;
        for (int value : arr){
            sum+=value;
        }
        System.out.print(sum - arr[arr.length-1]);
        System.out.print(" ");
        System.out.print(sum - arr[0]);

    }
}
