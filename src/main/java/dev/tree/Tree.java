package dev.tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree {
    public Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(int value) {
        this.root = new Node(value);
    }

    public void insert(int value) {

        Node newNode = new Node(value);

        // If there are no nodes in the tree
        if (this.root == null) {
            this.root = newNode;
            System.out.println("---Inserted given value as root node---");
            return ;
        }

        // If there are nodes in the tree
        Node rootNodeReference = this.root;
        while (true) {

            if (value < rootNodeReference.data) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    System.out.println("---Inserted " + value + " value as left leaf for one of the nodes---");
                    rootNodeReference.left = newNode;
                    return ;
                }

            } else {

                if (rootNodeReference.right != null) {
                    rootNodeReference = rootNodeReference.right;
                } else {
                    System.out.println("---Inserted " + value + " value as right leaf for one of the nodes---");
                    rootNodeReference.right = newNode;
                    return ;
                }

            }
        }
    }

    public boolean lookUp(int value) {

        Node rootNodeReference = this.root;

        while (rootNodeReference != null) {

            if (value < rootNodeReference.data) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    rootNodeReference = null;
                }

            } else if (value > rootNodeReference.data) {

                if (rootNodeReference.right != null) {
                    rootNodeReference = rootNodeReference.right;
                } else {
                    rootNodeReference = null;
                }

            } else {
                return true;
            }
        }
        return false;
    }

    public Node lookUpForReference(int value) {

        Node rootNodeReference = this.root;

        while (rootNodeReference != null) {

            if (value < rootNodeReference.data) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    rootNodeReference = null;
                }

            } else if (value > rootNodeReference.data) {

                if (rootNodeReference.right != null) {
                    rootNodeReference = rootNodeReference.right;
                } else {
                    rootNodeReference = null;
                }

            } else {
                return rootNodeReference;
            }
        }
        return null;
    }

    public void remove(int value) {
        // need to implement this
    }

    public void printTree(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            if (root.left != null) {
                printTree(root.left);
            }
            if (root.right != null) {
                printTree(root.right);
            }
        }

    }

    // This has been taken from Geeks forGeeks to test my tree implementation.
    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    static int COUNT = 10;

    void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
