package org.openx.task.tree.classes;

import org.junit.Assert;
import org.junit.Test;

public class TreeAnalyzerTest {

    @Test
    public void countLeafNodes() {
        Node testNode1 = Node.getTaskExampleTree();
        Assert.assertEquals(TreeAnalyzer.countLeafNodes(testNode1), 5);

        Node testNode2 = Node.createFromArray(new int[][] {{1}, {1,2}});
        Assert.assertEquals(TreeAnalyzer.countLeafNodes(testNode2), 2);

        Node testNode3 = Node.createFromArray(new int[][] {{1}});
        Assert.assertEquals(TreeAnalyzer.countLeafNodes(testNode3), 1);

        Assert.assertEquals(TreeAnalyzer.countLeafNodes(null), 0);
    }

    @Test
    public void maxDepth() {
        Node testNode1 = Node.getTaskExampleTree();
        Assert.assertEquals(TreeAnalyzer.maxDepth(testNode1), 4);

        Node testNode2 = Node.createFromArray(new int[][] {{1}, {1,2}});
        Assert.assertEquals(TreeAnalyzer.maxDepth(testNode2), 1);

        Node testNode3 = Node.createFromArray(new int[][] {{1}});
        Assert.assertEquals(TreeAnalyzer.maxDepth(testNode3), 0);

        Assert.assertEquals(TreeAnalyzer.maxDepth(null), 0);
    }

    @Test
    public void areNodesEqual() {
        Assert.assertTrue(TreeAnalyzer.areNodesEqual(Node.getTaskExampleTree(), Node.getTaskExampleTree()));
        Assert.assertTrue(TreeAnalyzer.areNodesEqual(null, null));
        Assert.assertTrue(TreeAnalyzer.areNodesEqual(Node.createFromArray(new int[][] {{1}}), Node.createFromArray(new int[][] {{1}})));

        Assert.assertFalse(TreeAnalyzer.areNodesEqual(Node.createFromArray(new int[][] {{1}}), Node.createFromArray(new int[][] {{2}})));
        Assert.assertFalse(TreeAnalyzer.areNodesEqual(Node.createFromArray(new int[][] {{1}}), Node.createFromArray(new int[][] {{1}, {1,2}})));
    }
}