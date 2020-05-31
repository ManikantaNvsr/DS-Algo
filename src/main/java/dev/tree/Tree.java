package dev.tree;

public class Tree {
    public Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(int value) {
        this.root = new Node(value);
    }

    public boolean insert(int value) {

        Node newNode = new Node(value);

        // If there are no nodes in the tree
        if (this.root == null) {
            this.root = newNode;
            System.out.println("---Inserted given value as root node---");
            return true;
        }

        // If there are nodes in the tree
        Node rootNodeReference = this.root;
        while (rootNodeReference != null) {

            if (value < rootNodeReference.data) {
                if (rootNodeReference.left != null) {
                    rootNodeReference = rootNodeReference.left;
                } else {
                    System.out.println("---Inserted " + value + " value as left leaf for one of the nodes---");
                    rootNodeReference.left = newNode;
                    return true;
                }

            } else {

                if (rootNodeReference.right != null) {
                    rootNodeReference = rootNodeReference.right;
                } else {
                    System.out.println("---Inserted " + value + " value as right leaf for one of the nodes---");
                    rootNodeReference.right = newNode;
                    return true;
                }

            }
        }

        return false;
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

}
