package org.openx.task.tree.classes;

public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public static Node createFromArray (int[][] array) {
        Node root = new Node(array[0][0]);

        for(int i = 0; i < array.length - 1; i++) {
            int[] parentArray = array[i];
            int[] childArray = array[i + 1];
            if(parentArray.length != childArray.length / 2) throw new RuntimeException("Wrong array");


            for(int j = 0; j < parentArray.length; j++) {
                int childIndex = j == 0 ? 0 : j * 2;

                Node parent = new Node(parentArray[j]);
                parent.leftNode = new Node(childArray[childIndex]);
                parent.rightNode = new Node(childArray[childIndex + 1]);

                System.out.println("Parent = " + parent.getValue());
                System.out.println("Left = " + parent.leftNode.getValue());
                System.out.println("Right = " + parent.rightNode.getValue() + '\n');
            }
        }

        return root;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
