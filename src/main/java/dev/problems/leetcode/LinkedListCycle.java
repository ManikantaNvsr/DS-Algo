package dev.problems.leetcode;

// LeetCode: 141
//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // Using O(n) memory
//        Set<ListNode> set = new HashSet();
//        ListNode temp = head;
//        boolean hasCycle = false;
//        while (temp != null) {
//            hasCycle = !set.add(temp);
//            if(hasCycle) break;
//            temp = temp.next;
//        }
//        return hasCycle;

        // Using O(1) memory
        // Consider a fast pointer which hops two nodes at once
        // Consider a slow pointer which hops one node at once
        // If the linked list contains a cycle,
        // these two pointers would meet at some point when they are looping around the list.
        ListNode fastPointer = null;
        ListNode slowPointer = null;
        if (head != null) {
            if (head.next != null) {
                fastPointer = head.next.next;
                slowPointer = head;
            } else {
                return false;
            }
        }
        while (fastPointer != null && fastPointer.next != null && slowPointer != null) {
            if (fastPointer == slowPointer) return true;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return false;
    }
}
