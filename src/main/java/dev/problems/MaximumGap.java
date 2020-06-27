package dev.problems;

import java.util.Arrays;

// (164)https://leetcode.com/problems/maximum-gap/
public class MaximumGap {

    public static void main(String[] args) {
        int[] nums = new int[]{3};

        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(nums));

    }

    public int maximumGap(int[] nums) {

        Arrays.sort(nums);

        int maximumGap = 0;

        for(int index = 0; index < nums.length - 1; index++){
            maximumGap = Math.max(maximumGap, Math.abs(nums[index] - nums[index+1]));
        }
        return maximumGap;
    }
}
