package org.example;

import dev.tree.Tree;



public class TestApp {

    public static void main(String[] args) {

        Tree tree = new Tree();
        /*int[] array = {47,2,40,20,38,30,14,28,10,16,19,44,39,27,7,9,31,12,43,21,5,41,34,49,13,33,3,4,25,22,29,15,32,35,6,24,23,26,1,11,42,36,37,17,18,8,45,48,50,46};
        for (int x:
             array) {
            tree.insert(x);
        }*/
        tree.insert(10);
        tree.insert(12);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.print2D(tree.root);

        }
}
