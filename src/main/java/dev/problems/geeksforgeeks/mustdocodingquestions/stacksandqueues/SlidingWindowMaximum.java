package dev.problems.geeksforgeeks.mustdocodingquestions.stacksandqueues;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length];

        // Brute Force
        // Iterate over through all the windows and find the maximum value for each window
        // For finding max value in each window takes O(k)
        // For n windows, it will become O(n * k)

        // Efficient Approach
        // Maintain Dequeue and an array for keeping the max for each window
        // case 1: The max of the current window(x) stays at the start of the queue and the incoming element is greater than x.
        // In the case 1, the next window max can be updated with the incoming value.
        return result;
    }

}
