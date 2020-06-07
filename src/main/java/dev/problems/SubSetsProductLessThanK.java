package dev.problems;


import java.util.Arrays;

// Number of subsets whose product is less than K
// see 713 for reference
public class SubSetsProductLessThanK {

    public static int numberOfSubSetsProductLessThankK(int[] nums, int k) {
        int numberOfSubSets = 0;
        int length = nums.length;
        // Approach
        // This window contains elements whose product is less than k
        // Slightly different to Sliding Window Approach as this window left index can go up to last element and the right index can take cyclic turn after reaching the end of elements
        // When we are done calculating number of Subsets in a window we go for a new window
        // We can calculate the number of subsets using a math formula : 2^n -1 which includes empty subset also

        // sort the given array
        Arrays.sort(nums);

        int leftIndex = 0;
        int rightIndex = 0;
        int product = 1;

        while (leftIndex < length) {
            product *= nums[rightIndex];
            if (product <= k) {

                // If all the elements product is less than K
                if (leftIndex == 0 && rightIndex == length - 1) {
                    numberOfSubSets += Math.pow(2, length) - 2;
                    return numberOfSubSets;
                }

                rightIndex++;
                rightIndex %= length;
            } else {
                System.out.println("leftIndex: " + leftIndex + " rightIndex: " + rightIndex);
                int numberOfElementsToBeConsidered;
                if (leftIndex > rightIndex) {
                    numberOfElementsToBeConsidered = length - leftIndex + rightIndex;
                    numberOfSubSets += Math.pow(2, numberOfElementsToBeConsidered) - 2;
                    leftIndex++;
                } else {
                    numberOfElementsToBeConsidered = rightIndex - leftIndex;
                    numberOfSubSets += numberOfElementsToBeConsidered > 1 ? Math.pow(2, rightIndex - leftIndex) - 2 : 1;// minus 2 because we are skipping the empty subset
                    leftIndex = rightIndex;
                }
                System.out.println("numberOfSubSets: " + numberOfSubSets);
                product = 1;

            }

        }
        // If the whole set can be a window, then we can answer straight away

        return numberOfSubSets;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};


        int numberOfSubSets = numberOfSubSetsProductLessThankK(nums, 7);

        System.out.println(numberOfSubSets);

    }
}

