package com.namanh.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal
 * Question: Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {
    /**
     * Iterate approach
     * S1: Similar preorder but reverse result
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if (root == null) return nodeList;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            nodeList.add(root.val);
            if (root.left != null) nodeStack.push(root.left);
            if (root.right != null) nodeStack.push(root.right);
        }
        Collections.reverse(nodeList);
        return nodeList;
    }

    /**
     * Recursive approach
     * S1: Check current node not null
     * S2: Call recursive function for left child first, then right child
     * S3: Add current node value to List
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        getNode(nodeList, root);
        return nodeList;
    }

    private void getNode(List<Integer> nodeList, TreeNode node) {
        if (node == null) return;
        getNode(nodeList, node.left);
        getNode(nodeList, node.right);
        nodeList.add(node.val);
    }
}
