package dev.problems.leetcode;

import dev.code.TreeNode;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {

    public DiameterOfBinaryTree() {
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root != null) {

            int leftSubTreeHeight = root.left != null ? getHeight(root.left) : -1;
            int rightSubTreeHeight = root.right != null ? getHeight(root.right) : -1;
            diameter = Math.max(diameter, leftSubTreeHeight + rightSubTreeHeight + 2);
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);

        } else {
            return 0;
        }
        return diameter;
    }

    public int getHeight(TreeNode node) {

        // there is no height if there are no nodes
        if (node != null) {// if there are no children
            if (node.left == null && node.right == null) {
                return 0;
            } else {
                int a = getHeight(node.left);
                int b = getHeight(node.right);
                return 1 + Math.max(a, b);
            }
        } else {
            return -1;
        }
    }
}
