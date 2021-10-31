package com.namanh.binary_tree;

import com.namanh.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal
 * Question: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    /**
     * Iterate approach
     * S1: Use stack to store node, push current node and all left children if not null
     * S2: Pop stack to get last element, add value to List
     * S3: Move current node to right child and continue
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            nodeList.add(root.val);
            root = root.right;
        }
        return nodeList;
    }

    /**
     * Recursive approach
     * S1: Check current node not null
     * S2: Call recursive function for left child
     * S3: Add current node value to List
     * S4: Call recursive function for right child
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        getNode(nodeList, root);
        return nodeList;
    }

    private void getNode(List<Integer> nodeList, TreeNode node) {
        if (node == null) return;
        getNode(nodeList, node.left);
        nodeList.add(node.val);
        getNode(nodeList, node.right);
    }
}
