package dev.problems.leetcode;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenAMultiLevelDoublyLinkedList {

    public Node flatten(Node head) {

        Node headReference = head;
        flattenList(headReference);
        return head;
    }

    private Node flattenList(Node currentNodeReference) {

        if (currentNodeReference.next == null) {
            return currentNodeReference;
        }
        Node tempNodeForNextNode = currentNodeReference.next;

        if (currentNodeReference.child != null) {

            currentNodeReference.next = currentNodeReference.child;
            currentNodeReference.child.prev = currentNodeReference;
            currentNodeReference = currentNodeReference.child;

        }
        {
            currentNodeReference = currentNodeReference.next;
        }

        currentNodeReference = flattenList(currentNodeReference);

        currentNodeReference.next = tempNodeForNextNode;
        tempNodeForNextNode.prev = currentNodeReference;

        return currentNodeReference;
    }
}
