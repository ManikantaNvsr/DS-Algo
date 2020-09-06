package dev.geeksforgeeks.mustdocodingquestions.heaps;

import java.util.ArrayList;
import java.util.Vector;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFromADataStream {

    // Naive Approach:
    // Take an ArrayList
    // Add elements and sort
    // calculate the median based on length
    // It is O(n log n) to find the median

//    private ArrayList<Integer> arrayList;
//
//    public MedianFromADataStream() {
//        arrayList = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        this.arrayList.add(num);
//    }
//
//    public double findMedian() {
//        this.arrayList.sort((e1, e2) -> e1 - e2);
//        int noOfElements = arrayList.size();
//        if (noOfElements % 2 == 0) {
//            return ((double) (arrayList.get(noOfElements / 2 - 1) + arrayList.get(noOfElements / 2))) / 2;
//        } else {
//            return arrayList.get(noOfElements / 2);
//        }
//
//    }

    // No need to code
    // Efficient Approach With Vector:
    // From the above approach, we find that it is easy to find median when the input elements are in sorted order.
    // Here, the invariant is that elements are always has to be in sorted order.
    // The above invariant matches with the variant of insertion sort
    // where we insert the element in the right place so that array is always in sorted order.
    // Let's use Binary search to find the position to make it faster
    // Here, the input is dynamic. So, we can't deal with arrays.
    // Vector can act as a resizable array.
    // Let's use Vector instead of ArrayList.
    // As we are sorting while inserting itself,
    // find the median will happen in constant time and the adding will take O(n) [~O(log n) + O(n)]

    //TODO Code this approach
    // Using two heaps (check the above link for more about this approach.)

}
