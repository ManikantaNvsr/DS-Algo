package dev.code;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node() {
        this.next = null;
        this.prev = null;
    }

    public Node(int i) {
        this.data = i;
        this.next = null;
        this.prev = null;
    }
}