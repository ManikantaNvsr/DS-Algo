package dev.problems;

// https://leetcode.com/contest/biweekly-contest-29/problems/longest-subarray-of-1s-after-deleting-one-element/
public class LongestSubArray {

    public static void main(String[] args) {
        LongestSubArray longestSubArray = new LongestSubArray();
        System.out.println(longestSubArray.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubArray.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubArray.longestSubarray(new int[]{1, 1, 1}));
        System.out.println(longestSubArray.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(longestSubArray.longestSubarray(new int[]{0, 0, 0}));
    }

    public int longestSubarray(int[] nums) {

        int maximumLength = 0;
        boolean atleastOneZero = false;
        int length = nums.length;

        for (int i = 0; i < length; i++) {

            if (nums[i] == 0) {
                atleastOneZero = true;
                int leftIndex = i - 1;
                int rightIndex = i + 1;
                int leftSum = 0;
                int rightSum = 0;
                // calculate left
                while (leftIndex > -1 && nums[leftIndex] != 0) {
                    leftSum += nums[leftIndex];
                    leftIndex--;
                }
                // calculate right
                while (rightIndex < length && nums[rightIndex] != 0) {
                    rightSum += nums[rightIndex];
                    rightIndex++;
                }

                maximumLength = Math.max(maximumLength, leftSum + rightSum);
            }

        }

        if (!atleastOneZero) {
            return length - 1;
        }


        return maximumLength;

    }
}
