package com.namanh.bfs;

import com.namanh.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/deepest-leaves-sum
 * Q: Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * S1: Use BFS algorithm to visit tree
 * S2: Use Queue to store node, push root to queue
 * S3: Each step, reset current sum, get current size of queue, assume n, pop n element out of queue
 * S4: When pop element, add value to current sum, push left and right children to queue
 * S5: Stop when queue is empty, return current sum
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int currentSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            currentSum = 0;
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return currentSum;
    }
}
