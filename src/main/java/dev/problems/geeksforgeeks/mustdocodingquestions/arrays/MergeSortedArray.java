package dev.problems.geeksforgeeks.mustdocodingquestions.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Brute-force:
        // Iterate over each element of nums2
        // Find a sorted place for the element and push element into the nums1 by shifting other elements. O(n^2)
        // OR
        // add nums2 to nums1 and sort nums1 O(n log n)

        //
        // Efficient Approach
        // Compare elements in both arrays from the right
        // fill the nums1 from last index since it has extra space enough to store nums2
        int fillingIndex = nums1.length - 1;
        // last element index can be found by m -1
        // But if it is 0, that means, there are no elements in nums1 and only nums2 elements have to be placed in nums1
        // This case is covered by Line System.arraycopy(nums2, 0, nums1, 0, n);
        int pointerOfNums1 = m - 1;
        int pointerOfNums2 = n - 1;
        while (pointerOfNums2 > -1 && pointerOfNums1 > -1) {
            if (nums2[pointerOfNums2] >= nums1[pointerOfNums1]) {
                nums1[fillingIndex--] = nums2[pointerOfNums2--];
            } else {
                nums1[fillingIndex--] = nums1[pointerOfNums1--];
            }
        }

        // Adding elements which are missed from adding in nums1
        System.arraycopy(nums2, 0, nums1, 0, pointerOfNums2 + 1);

//        System.out.println(Arrays.toString(nums1));
    }
}
