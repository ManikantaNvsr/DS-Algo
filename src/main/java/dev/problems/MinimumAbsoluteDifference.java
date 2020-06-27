package dev.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

//1200
//https://leetcode.com/problems/minimum-absolute-difference/
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> resultList = new ArrayList();
        int minimumAbsoluteDifference = Integer.MAX_VALUE;


        for (int index = 0; index < arr.length-1; index++) {
            // we need to find minimum absolute difference pairs only
            int absoluteDifference = Math.abs(arr[index] - arr[index + 1]);
            if(minimumAbsoluteDifference > absoluteDifference){
                minimumAbsoluteDifference = absoluteDifference;
            }
        }

        for (int index = 0; index < arr.length-1; index++) {

            if(Math.abs(arr[index] - arr[index + 1]) == minimumAbsoluteDifference){
                    List<Integer> pair = new ArrayList();
                    pair.add(arr[index]);
                    pair.add(arr[index + 1]);
                    resultList.add(pair);
                }
            }

        return resultList;
    }

}
