package dev.problems;

//https://leetcode.com/problems/maximum-width-ramp/
public class MaximumWidthRamp {

    public static void main(String[] args) {

        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
//        int[] A = {3,4,2,1};
//        int[] A = {3,1,2};
        int[] A = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
//        int[] A = {5,1,1,0,1,9,4,0,4,1};
//        int[] A = {6,0,8,2,1,5};
//        int[] A = {8, 5, 6, 4, 10, 3, 1};
//        int[] A = {2,2,1};
        System.out.println(maximumWidthRamp.maxWidthRamp(A));

    }

    public int maxWidthRamp(int[] A) {
        int lastIndexOfArray = A.length - 1;
        int leftIndex = 0;
        int rightIndex = lastIndexOfArray;
        int maxWidthRamp = 0;

        while (leftIndex < rightIndex) {
            // we don't need to calculate the maximum width ramp for indexes whose width less than already calculated ramp
            if (maxWidthRamp > rightIndex - leftIndex) {
                leftIndex++;
                rightIndex = lastIndexOfArray;
                continue;
            }
            // calculating width of ramp for a satisfying index positions
            if (A[leftIndex] <= A[rightIndex]) {
                maxWidthRamp = Math.max(maxWidthRamp, rightIndex - leftIndex);
                leftIndex++;
                rightIndex = lastIndexOfArray;
                continue;
            } else {
                rightIndex--;
            }
            // It is to move the left index to a new element when we have exhausted a starting element combinations
            if (leftIndex == rightIndex) {
                leftIndex++;
                rightIndex = lastIndexOfArray;
            }
        }

        return maxWidthRamp;
    }
}
