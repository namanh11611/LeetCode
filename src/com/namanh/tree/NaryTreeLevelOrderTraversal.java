package com.namanh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal
 * Q: Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * S1: Use BFS algorithm to visit all node. Use Queue to store value, push root node to queue
 * S2: Each step, get current size of queue, assume n, pop n elements and add value to sub list
 * S3: When pop, push all children node to queue
 * S4: Push sub list to parent list
 * S5: Stop when queue empty
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                Node node = queue.poll();
                subList.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
