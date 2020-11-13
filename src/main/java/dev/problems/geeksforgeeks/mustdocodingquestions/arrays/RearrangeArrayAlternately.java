package dev.problems.geeksforgeeks.mustdocodingquestions.arrays;

import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
public class RearrangeArrayAlternately {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        while (testcases > 0) {
            int arraySize = scanner.nextInt();
            int[] array = new int[arraySize];
            // load array elements
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
            }

            // Brute Force:
            // Two pointers to the array left end and right end of the array
            // Load a new array alternately using these pointers
            // Space: O(n)
            // Time: O(n)

            // My Efficient

            System.out.println(Arrays.toString(array));
            testcases--;
        }
    }
}
