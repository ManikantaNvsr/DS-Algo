package dev.code;

public class Node {
    public int data;

    // left, right will be used for Tree implementations
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
