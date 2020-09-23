package dev.problems.geeksforgeeks.mustdocodingquestions.trees;

import dev.implementations.TreeNode;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBinaryTree {

    void leftView(TreeNode root) {
        StringBuilder result = new StringBuilder();
        while (root != null) {
            result.append(root.val).append(" ");
            root = root.left != null ? root.left : root.right;
        }
        System.out.print(result.toString().trim());
    }
}
