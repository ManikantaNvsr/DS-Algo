package dev.code;

import java.util.TreeMap;

public class Tree {
    public Node root;
    public int height = 0;
    private TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
    private int cursorForTopView = 0;

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
            return;
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
                    return;
                }

            } else {

                if (rootNodeReference.right != null) {
                    rootNodeReference = rootNodeReference.right;
                } else {
                    System.out.println("---Inserted " + value + " value as right leaf for one of the nodes---");
                    rootNodeReference.right = newNode;
                    return;
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

        // This is a pre order traversal print function
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

    public void printTreePostOrder(Node root) {

        // This is a post order traversal print function
        if (root != null) {
            if (root.left != null) {
                printTreePostOrder(root.left);
            }
            if (root.right != null) {
                printTreePostOrder(root.right);
            }
            System.out.print(root.data + " ");
        }

    }

    public void printTreeInOrder(Node root) {

        // This is a in order traversal print function
        if (root != null) {
            if (root.left != null) {
                printTreeInOrder(root.left);
            }
            System.out.print(root.data + " ");
            if (root.right != null) {
                printTreeInOrder(root.right);
            }
        }

    }


    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeHeight = heightOfTree(root.left);
            int rightTreeHeight = heightOfTree(root.right);
            return 1 + Math.max(leftTreeHeight, rightTreeHeight);
        }
    }

    public void topViewForAnyTree(Node root) {

    }

    public void topViewForBinaryTree(Node root) {
        // consider root node as 0 cursor and take the respective distances from rootnode to find indexes of topview elements
        if (!treeMap.containsKey(cursorForTopView)) {
            treeMap.put(cursorForTopView, root.data);
        } else {
            if (root.data > treeMap.get(cursorForTopView)) {
                treeMap.put(cursorForTopView, root.data);
            }
        }

            if (root.left != null) {
                cursorForTopView = cursorForTopView - 1;
                topViewForBinaryTree(root.left);
            }

            if (root.right != null) {
                cursorForTopView = cursorForTopView + 1;
                topViewForBinaryTree(root.right);
            }

        // making the cursor for topview is zero when it comes back to rootnode after iterating all the connecting nodes in the left subtree

        cursorForTopView = 0;

        System.out.println(treeMap.toString());
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
