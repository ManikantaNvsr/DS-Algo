package dev.problems;

import dev.code.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // The Leaf nodes have index 0
        int indexOfTheRowInTree = 0;

        List<List<Integer>> result = new ArrayList<>();

        loop(root, indexOfTheRowInTree, result);

        Collections.reverse(result);
        return result;
    }

    public void loop(TreeNode root, int indexOfTheRowInTree, List<List<Integer>> result) {

        if(root!=null){

            if(indexOfTheRowInTree < result.size()){
                result.get(indexOfTheRowInTree).add(root.val);
            }
            else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(root.val);
                result.add(temp);
            }


            if (root.left != null) {
                TreeNode temp = root.left;
                indexOfTheRowInTree++;
                loop(temp, indexOfTheRowInTree, result);
                indexOfTheRowInTree--;
            }

            if (root.right != null) {
                TreeNode temp  = root.right;
                indexOfTheRowInTree++;
                loop(temp, indexOfTheRowInTree, result);
                indexOfTheRowInTree--;
            }

        }


    }
}
