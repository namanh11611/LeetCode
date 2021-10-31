package com.namanh.bfs;

import com.namanh.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view
 * Q: Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 *
 * S1: Use BFS and Queue, visit from right to left child node
 * S2: Each step, add first element value to result
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            result.add(queue.peek().val);
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return result;
    }
}
