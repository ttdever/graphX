package org.openx.task.tree;

import org.openx.task.tree.classes.TreeAnalyzer;
import org.openx.task.tree.classes.Node;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{5}, {3, 7}, {2, 5, 1, 0}};
        Node testNode = Node.createFromArray(array);
    }
}