package dev.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

// LeetCode: 142
// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        // Using O(1) memory
        // Consider a fast pointer which hops two nodes at once
        // Consider a slow pointer which hops one node at once
        // If the linked list contains a cycle,
        // these two pointers would meet at some point when they are looping around the list.
        ListNode fast = null;
        ListNode slow = null;
        if (head != null) {
            if (head.next != null) {
                fast = head.next.next;
                slow = head;
            } else {
                return null;
            }
        }
        while (fast != null && fast.next != null) {
            Set<ListNode> collection = new HashSet<>();
            if (fast == slow) {
                // Once the cycle is detected, There are two ways to handle it.
                // 1. https://stackoverflow.com/a/26569770/8573084
                // 2. https://stackoverflow.com/a/6110767/8573084
                // Here, I'm doing the second way
//                slow = head;
//                while (slow != fast) {
//                    slow = slow.next;
//                    fast = fast.next;
//                }
//                return fast;
                // 3. My easy solution
//                 move slow pointer to head and keep fast pointer at the meeting point
//                 now while moving slow and fast pointers through a single hop, store the slow reference in a collection
//                 everytime you hop the fast pointer, check the fast pointer reference exits in that collection.
//                 since slow pointer is coming behind the fast pointer, at some point fast pointer reference contains in that collection stored above
//                 stop when the fast pointer exists in that collection, that is our cycle starting point.
                // Here, I'm doing the third approach
                slow = head;
                collection.add(slow);
                while (!collection.contains(fast)) {
                    slow = slow.next;
                    collection.add(slow);
                    fast = fast.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}
