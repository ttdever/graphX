package org.openx.task.tree.classes;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;
    private Node parent;

    public Node(int value) {
        this.value = value;
    }

    public static Node createFromArray(int[][] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Node root = new Node(array[0][0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int row = 1;
        while (!queue.isEmpty() && row < array.length) {
            int count = queue.size();
            int[] parentArray = array[row - 1];
            int[] childArray = array[row];

            if (parentArray.length != count || childArray.length != 2 * count) {
                throw new IllegalArgumentException("Invalid input array");
            }

            for (int i = 0; i < count; i++) {
                Node node = queue.poll();

                int leftValue = childArray[i * 2];
                int rightValue = childArray[i * 2 + 1];

                if (leftValue != -1) {
                    Node leftNode = new Node(leftValue);
                    node.setLeftNode(leftNode);
                    queue.add(leftNode);
                }

                if (rightValue != -1) {
                    Node rightNode = new Node(rightValue);
                    node.setRightNode(rightNode);
                    queue.add(rightNode);
                }
            }

            row++;
        }

        return root;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        leftNode.parent = this;
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        rightNode.parent = this;
        this.rightNode = rightNode;
    }
}
