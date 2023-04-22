package org.openx.task.tree.classes;

public class TreeAnalyzer {
    public static void print(Node current, int depth) {
        if (current == null) return;
        System.out.println("_".repeat(depth) + current.getValue());
        print(current.getLeftNode(), depth + 1);
        print(current.getRightNode(), depth + 1);
    }

    public static int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.getLeftNode() == null && node.getRightNode() == null) return 1;
        return countLeafNodes(node.getLeftNode()) + countLeafNodes(node.getRightNode());
    }

    public static int maxDepth(Node node) {
        return node == null ? 0 : calculateNodeDepth(node) - 1;
    }

    private static int calculateNodeDepth(Node node) {
        if (node == null) return 0;

        int leftDepth = calculateNodeDepth(node.getLeftNode());
        int rightDepth = calculateNodeDepth(node.getRightNode());

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static boolean areNodesEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else if (node1.getValue() != node2.getValue()) return false;
        else {
            boolean leftEqual = areNodesEqual(node1.getLeftNode(), node2.getLeftNode());
            boolean rightEqual = areNodesEqual(node1.getRightNode(), node2.getRightNode());
            return leftEqual && rightEqual;
        }
    }
}
