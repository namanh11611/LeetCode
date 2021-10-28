package com.namanh.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal
 * Question: Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {
    /**
     * Iterate approach
     * S1: Use stack to store node, push root if not null
     * S2: Pop stack to get last element, add value to List
     * S3: Check children not null, push right child first, then left child to stack
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if (root == null) return nodeList;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            nodeList.add(root.val);
            if (root.right != null) nodeStack.push(root.right);
            if (root.left != null) nodeStack.push(root.left);
        }
        return nodeList;
    }

    /**
     * Recursive approach
     * S1: Check current node not null, add value to List
     * S2: Call recursive function for left child first, then right child
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        getNode(nodeList, root);
        return nodeList;
    }

    private void getNode(List<Integer> nodeList, TreeNode node) {
        if (node == null) return;
        nodeList.add(node.val);
        getNode(nodeList, node.left);
        getNode(nodeList, node.right);
    }
}
