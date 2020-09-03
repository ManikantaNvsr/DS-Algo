package dev.geeksforgeeks.mustdocodingquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        while (testcases > 0) {
            int arraySize = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[] array = new int[arraySize];

            // load array elements
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
            }

            // Naive Approach:
            // Get all the possible combinations of sub-arrays starting with each index
            // When the target sum matches the sum of these sub arrays, we get the sub-array with the target sum

            // Sliding Window Approach: (handles non-negative numbers)
            // Consider a window from starting element
            // 1. Add elements to the right side of the window until it matches the target sum
            // 2. If the sum of the window reaches more than the target sum, try to remove element from the start of the window
            // Repeat 1,2 until the window sum reaches target sum
            /*int leftOfWindow = 0;
            int rightOfWindow = 0;
            int windowSum = 0;

            while (leftOfWindow <= rightOfWindow) {
                if (windowSum == targetSum) {
                    System.out.println((leftOfWindow + 1) + " " + rightOfWindow);
                    break;
                } else if (windowSum > targetSum) {
                    windowSum -= array[leftOfWindow++];
                } else {
                    if (rightOfWindow < arraySize) {
                        windowSum += array[rightOfWindow++];
                    } else {
                        break;
                    }
                }
            }
            // If target sum is not there, returning -1
            if (windowSum != targetSum) {
                System.out.println(-1);
            }*/

            // Let's say window has a negative number at the start and the window sum is greater than the target sum.
            // As per the above approach, if we remove the start then the window sum will increase.
            // So the above sliding window solution doesn't work in case of negative numbers.

            // HashMap Approach: Handles Negative Numbers in the array as well
            // Iterate through each element in the array
            // In each iteration, add the element to the currentSum=0
            // Maintain the hashmap with key: sum until that index value: index
            // check if currentSum equals to the target sum. If it's true, return the indexes.
            // Otherwise, check currentSum-targetSum is already there in the hashmap keys.
            // If it is there, we found the subArray that equals to the target sum.
            // Otherwise, keep adding to the hashmap.
            HashMap<Integer, Integer> hashMap = new HashMap();
            int currentSum = 0;
            boolean isSubArrayFound = false;
            for (int a = 0; a < arraySize; a++) {
                currentSum += array[a];
                // check if currentSum equals to the target sum. If it's true, return the indexes.
                if (currentSum == targetSum) {
                    System.out.println((1) + " " + (a + 1));
                    isSubArrayFound = true;
                    break;
                }
                // Otherwise, check currentSum-targetSum is already there in the hashmap keys.
                // If it is there, we found the subArray that equals to the target sum.
                if (hashMap.containsKey(currentSum - targetSum)) {
                    int startPosition = hashMap.get(currentSum - targetSum);
                    // Adding +2 for matching with real world positions starting with index 1
                    System.out.println((startPosition + 2) + " " + (a + 1));
                    isSubArrayFound = true;
                    break;
                }
                // Maintain the hashmap with key: sum until that index value: index
                hashMap.put(currentSum, a);
            }
            if (!isSubArrayFound) {
                System.out.println(-1);
            }
            testcases--;
        }
    }

}
