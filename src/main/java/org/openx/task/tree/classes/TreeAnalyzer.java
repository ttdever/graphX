package org.openx.task.tree.classes;

public class TreeAnalyzer {
    public static void print(Node current, int depth) {
        if (current == null) return;

        System.out.println("_".repeat(depth) + current.getValue());
        print(current.getLeftNode(), depth + 1);
        print(current.getRightNode(), depth + 1);
    }
}
