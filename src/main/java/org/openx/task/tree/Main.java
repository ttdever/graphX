package org.openx.task.tree;

import org.openx.task.tree.classes.TreeAnalyzer;
import org.openx.task.tree.classes.Node;

public class Main {
    public static void main(String[] args) {
        Node node1 = Node.getTaskExampleTree();
        Node node2 = Node.createFromArray(new int[][] {{1}, {1,2}});
        System.out.println(TreeAnalyzer.areNodesEqual(node1, node2));
    }
}