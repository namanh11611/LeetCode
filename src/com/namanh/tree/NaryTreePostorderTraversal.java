package com.namanh.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal
 * Q: Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * S1: Similar binary tree postorder traversal
 *
 * Time: O(n)
 * Space: average case O(log(n)), worst case O(n)
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> nodeList = new ArrayList<>();
        if (root == null) return nodeList;

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            nodeList.add(root.val);
            for (Node node : root.children) {
                nodeStack.push(node);
            }
        }
        Collections.reverse(nodeList);
        return nodeList;
    }
}
