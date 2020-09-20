package dev.problems.geeksforgeeks.mustdocodingquestions.arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/count-the-triplets/0
public class CountTriplets {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 2};

        System.out.println(new CountTriplets().countTriplet(arr, arr.length));
    }

    int countTriplet(int[] arr, int n) {
        int numberOfTriplets = 0;

        // Brute Force Approach: O(n^3)
        // Generate all the possible combinations of 2 elements from the array O(n^2)
        // Check for the sum of a combination in the array O(n)
        // Increment the numberOfTriplets everytime we find a match for the sum in the given array

        // Effective Approach: O(n^2)
//        Sort the array first
//        Let’s consider the sum of two elements as the third element(i) from the last of the array.
//        Let’s consider two elements one(j) from the start of the array and the other (k) from just before the last of the array.
//        If the sum of j + k is less than the i, increment j and check again.
//        If the sum of j+k is greater than the i, decrement k and check again.
//        If j is not less than k, that means, they are referring to the same element, in this case, decrement i and make j=0, k=i-1 then check again.
        Arrays.sort(arr);
        for (int i = n - 1; i > -1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) {
//                    System.out.println("Target Element: " + arr[i]);
//                    System.out.println("Pair Elements: " + arr[j] + " " + arr[k]);
                    numberOfTriplets++;
                    k--;
                    j++;
                } else if (arr[j] + arr[k] < arr[i]) {
                    j++;
                } else if (arr[j] + arr[k] > arr[i]) {
                    k--;
                }
            }
        }
        return numberOfTriplets;
    }
}
