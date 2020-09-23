package dev.problems.geeksforgeeks.mustdocodingquestions.heaps;

import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFromADataStream {

    public static void main(String[] args) {
        MedianFromADataStream medianFromADataStream = new MedianFromADataStream();
        medianFromADataStream.addNum(1);
        medianFromADataStream.addNum(2);
        System.out.println(medianFromADataStream.findMedian());
    }

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

    // Using two heaps (check the above link for more about this approach.):
//    The above two approaches gave us some insights on how to tackle this problem. Concretely, one can infer two things:

//    If we could maintain direct access to median elements at all times, then finding the median would take a constant amount of time.
//    If we could find a reasonably fast way of adding numbers to our containers, additional penalties incurred could be lessened.
//    But perhaps the most important insight, which is not readily observable, is the fact that we only need a consistent way to access the median elements.
//    Keeping the entire input sorted is not a requirement.

//    Heaps are a natural ingredient for this dish!
//    Adding elements to them take logarithmic order of time. They also give direct access to the maximal/minimal elements in a group.
//    If we could maintain two heaps in the following way:
//    A max-heap to store the smaller half of the input numbers
//    A min-heap to store the larger half of the input numbers
//    This gives access to median values in the input: they comprise the top of the heaps!
    // Average of the top of the heaps when they have equal number of elements.
    // Otherwise, the top of max-heap of smaller half of the input numbers.
    // We need to make sure that these heaps are either equal or max-heap_elements - min-heap_elements = 1.
    // It is O(log n) since it takes only O(log n) to add an element and the find median can done in a constant time.


    PriorityQueue<Integer> minHeap; // It's for larger half of elements.
    PriorityQueue<Integer> maxHeap; // It's for smaller half of elements.

    public MedianFromADataStream() {
        minHeap = new PriorityQueue<>();// by default min heap is created
        // Creating a max heap by sending a comparator for descending order.
        maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
    }

    public void addNum(int num) {
        // When both heap sizes are equal, we can only add to the maxHeap because of the median condition mentioned in line 69.
        if (maxHeap.size() == minHeap.size()) {
            // When the heaps are empty, we just add to the max heap
            // Otherwise, if num is greater than minHeap peek, we add top of the minHeap to the maxHeap and push num to the minHeap
            if (maxHeap.isEmpty() || minHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            return;
        }
        if (maxHeap.size() - minHeap.size() == 1) {

            if (num < maxHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }

        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    // There are more ways of solving this problem in the link above.


}
