package org.example;

import dev.tree.Tree;


public class TestApp {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        System.out.println(tree.lookUp(6));

    }
}
