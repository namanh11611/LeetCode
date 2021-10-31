package com.namanh.bfs;

import com.namanh.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * Q: Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left
 * to right, level by level from leaf to root).
 *
 * S1: Use BFS algorithm to visit tree
 * S2: Use Queue to store node, push root to queue
 * S3: Each step, get current size of queue, assume n, pop n element out of queue
 * S4: When pop element, push value to sub list, push left and right children to queue
 * S5: Push sublist to result
 * S6: Stop when queue is empty
 * S7: Reverse result
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(subList);
        }
        Collections.reverse(result);
        return result;
    }
}
