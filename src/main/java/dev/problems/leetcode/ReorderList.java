package dev.problems.leetcode;

// https://leetcode.com/problems/reorder-list/
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        int lengthOfList = length(head);
        ListNode currentNode = head;
        ListNode lastNode = traverseToLastNode(head);

        // iterate until the last but one pair is adjusted
        for (int index = 0; index < lengthOfList - 2; index = index + 2) {

            ListNode nodeBeforeLastNode = traverseToIndex(lengthOfList - 2, head);


            // insert last node after the first node
            nodeBeforeLastNode.next = null;
            lastNode.next = currentNode.next;
            currentNode.next = lastNode;

            // getting ready for the next iteration
            currentNode = lastNode.next;
            lastNode = nodeBeforeLastNode;

        }
    }

    public int length(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    private ListNode traverseToIndex(int index, ListNode head) {
        ListNode nodeAtGivenIndex = head;

        // getting node just before given index using while loop
        while (index > 0) {
            nodeAtGivenIndex = nodeAtGivenIndex.next;
            index--;
        }
        return nodeAtGivenIndex;
    }

    private ListNode traverseToLastNode(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode useNode = head;

        while (useNode != null) {
            System.out.print(useNode.val + "-->");
            useNode = useNode.next;
        }

        // print(useNode);

    }
}
