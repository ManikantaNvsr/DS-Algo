package dev.implementations;

import java.util.TreeMap;

public class Tree {
    public TreeNode root;
    public int height = 0;
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private int cursorForTopView = 0;

    public Tree() {
        this.root = null;
    }

    public Tree(int value) {
        this.root = new TreeNode(value);
    }

    public void insert(int value) {

        TreeNode newNode = new TreeNode(value);

        // If there are no nodes in the tree
        if (this.root == null) {
            this.root = newNode;
            System.out.println("---Inserted given value as root node---");
            return;
        }

        // If there are nodes in the tree
        TreeNode rootNodeReference = this.root;
        while (true) {

            if (value < rootNodeReference.val) {
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

        TreeNode rootNodeReference = this.root;

        while (rootNodeReference != null) {

            if (value < rootNodeReference.val) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    rootNodeReference = null;
                }

            } else if (value > rootNodeReference.val) {

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

    public TreeNode lookUpForReference(int value) {

        TreeNode rootNodeReference = this.root;

        while (rootNodeReference != null) {

            if (value < rootNodeReference.val) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    rootNodeReference = null;
                }

            } else if (value > rootNodeReference.val) {

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

    public void printTree(TreeNode root) {

        // This is a pre order traversal print function
        if (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null) {
                printTree(root.left);
            }
            if (root.right != null) {
                printTree(root.right);
            }
        }

    }

    public void printTreePostOrder(TreeNode root) {

        // This is a post order traversal print function
        if (root != null) {
            if (root.left != null) {
                printTreePostOrder(root.left);
            }
            if (root.right != null) {
                printTreePostOrder(root.right);
            }
            System.out.print(root.val + " ");
        }

    }

    public void printTreeInOrder(TreeNode root) {

        // This is a in order traversal print function
        if (root != null) {
            if (root.left != null) {
                printTreeInOrder(root.left);
            }
            System.out.print(root.val + " ");
            if (root.right != null) {
                printTreeInOrder(root.right);
            }
        }

    }


    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeHeight = heightOfTree(root.left);
            int rightTreeHeight = heightOfTree(root.right);
            return 1 + Math.max(leftTreeHeight, rightTreeHeight);
        }
    }

    public void topViewForAnyTree(TreeNode root) {

    }

    public void topViewForBinaryTree(TreeNode root) {
        // consider root node as 0 cursor and take the respective distances from rootnode to find indexes of topview elements
        if (!treeMap.containsKey(cursorForTopView)) {
            treeMap.put(cursorForTopView, root.val);
        } else {
            if (root.val > treeMap.get(cursorForTopView)) {
                treeMap.put(cursorForTopView, root.val);
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

    void print2DUtil(TreeNode root, int space) {
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
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D(TreeNode root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    // height of a node
    public int getHeight(TreeNode node) {

        // there is no height if there are no nodes
        if (node == null) {
            return -1;
        }

        // if there are no children
        if (node.left == null && node.right == null) {
            return 0;
        } else {
            int a = getHeight(node.left);
            int b = getHeight(node.right);
            return 1 + Math.max(a, b);
        }


    }
}
