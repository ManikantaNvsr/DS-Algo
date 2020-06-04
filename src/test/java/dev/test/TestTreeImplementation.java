package dev.test;

import dev.code.Tree;

import dev.problems.DiameterOfBinaryTree;
import org.junit.Test;

public class TestTreeImplementation {

    @Test
    public void testTree() {

        Tree tree = new Tree();
        /*int[] array = {47,2,40,20,38,30,14,28,10,16,19,44,39,27,7,9,31,12,43,21,5,41,34,49,13,33,3,4,25,22,29,15,32,35,6,24,23,26,1,11,42,36,37,17,18,8,45,48,50,46};
        for (int x:
             array) {
            tree.insert(x);
        }*/
        tree.insert(10);
        /*tree.insert(7);
        *//*tree.insert(12);*//*
        */tree.insert(4);
        tree.insert(9);
        tree.print2D(tree.root);

        DiameterOfBinaryTree dBT = new DiameterOfBinaryTree();

        System.out.println(dBT.diameterOfBinaryTree(tree.root));

    }
}
