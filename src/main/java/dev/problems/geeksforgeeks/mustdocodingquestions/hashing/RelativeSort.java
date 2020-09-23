package dev.problems.geeksforgeeks.mustdocodingquestions.hashing;

import java.util.*;

//https://leetcode.com/problems/relative-sort-array/
public class RelativeSort {

    public static void main(String[] args) {

        RelativeSort relativeSort = new RelativeSort();
        System.out.println(Arrays.toString(relativeSort.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int startIndex = 0;
        int endIndex = arr1.length - 1;
        // create LinkedHashMap to preserve the sorting order of array 2 in the keys and the respective frequency
        // Loading it with zero initially.
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int value : arr2) {
            map.put(value, 0);
        }
        // iterate all the elements from the array 1 and add their frequency to the map above.
        for (int value : arr1) {
            if (map.containsKey(value)) {
                // Noting the frequency if the array 2 has the value
                map.put(value, map.get(value) + 1);
            } else {
                // adding the elements which are not there in array 2 to the end of the result array
                result[endIndex--] = value;
            }
        }
        // Load the result array
        for (int value : arr2) {
            for (int i = 0; i < map.get(value); i++) {
                result[startIndex++] = value;
            }
        }

        // soring the elements which are not there in array 2
        Arrays.sort(result, endIndex + 1, result.length);

        return result;
    }
}
