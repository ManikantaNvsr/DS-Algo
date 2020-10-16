package dev.problems.geeksforgeeks.mustdocodingquestions.linkedlists;

import dev.algorithms.Node;

//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
public class MiddleElementInLinkedList {

    public int getMiddle(Node head) {
        Node speedPointer = head;
        Node slowPointer = head;
        // If it is only a single element.
        if (head.next == null) {
            return head.data;
        }
        // If it is of two elements.
        if (head.next.next == null) {
            return head.next.data;
        }
        // If it is greater than two elements, we hop the speed pointer two elements and the slow pointer one element
        // By the time, the speed pointer reached the end of the list, the slow pointer would reach the middle element.
        while (speedPointer != null && speedPointer.next != null) {
            speedPointer = speedPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
    }
}
