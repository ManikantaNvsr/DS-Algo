package dev.problems.geeksforgeeks.mustdocodingquestions.arrays;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maximumValue = Integer.MIN_VALUE;

        // Kadane's Algorithm
        // Initialize curr_max = 0, and maximumValue = minimum integer value.
        // Iterate over the array by adding each element to the curr_max, If the sum at any time is less than zero, make curr_max = 0.
        // If the sum at any time more than the maximumValue then replace maximumValue with curr_max value.
        // Finally, we will have the required max value in the maximumValue. O(n)
        int currentSubArraySum = 0;
        for (int num : nums) {
            currentSubArraySum = currentSubArraySum + num;
            // If the currentSubArraySum is more than maxValue, we have to replace maxValue with currentSubArraySum.
            if (currentSubArraySum > maximumValue) {
                maximumValue = currentSubArraySum;
            }
            // If the currentSubArraySum is less than 0, it is a negative value , it will reduce the sum if keep it.
            // just make it zero to not consider the currentSubArraySum until now and start afresh.
            if (currentSubArraySum < 0) {
                currentSubArraySum = 0;
            }
        }

        // TODO divide and conquer approach


        return maximumValue;
    }
}
