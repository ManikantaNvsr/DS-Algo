package dev.problems.leetcode;

import dev.implementations.TreeNode;

import java.util.TreeSet;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/
// https://www.geeksforgeeks.org/continuous-tree/
public class ContinuousTree {

    // GFG: whenever we get this absolute difference more than 1 then it is not a continuous tree.
    // GFG: We don't check the difference for all the nodes, We check only parent and the child differences as per the definition of Continuous tree.

    public int getMinimumDifference(TreeNode root) {
        int minAbsoluteDifference = Integer.MAX_VALUE;
        int numberOfNodes = 0;
        TreeSet<Integer> values = new TreeSet<>();
        if (root != null) {
            numberOfNodes++;
            values.add(root.val);
            addAllNodes(root, values, numberOfNodes);
        }
        if (values.size() < numberOfNodes) {
            return 0;
        }
        int[] valuesArray = new int[values.size()];
        int index = 0;
        for (int value : values) {
            valuesArray[index] = value;
            index++;
        }

        for (index =0; index < valuesArray.length - 1; index++) {

            minAbsoluteDifference = Math.min(minAbsoluteDifference, Math.abs(valuesArray[index] - valuesArray[index + 1]));
        }

        return minAbsoluteDifference;
    }

    private void addAllNodes(TreeNode root, TreeSet<Integer> values, int numberOfNodes) {

        // This is a pre order traversal
        if (root != null) {
            if (root.left != null) {
                numberOfNodes++;
                values.add(root.left.val);
                addAllNodes(root.left, values, numberOfNodes);
            }
            if (root.right != null) {
                numberOfNodes++;
                values.add(root.right.val);
                addAllNodes(root.right, values, numberOfNodes);
            }
        }
    }
}
