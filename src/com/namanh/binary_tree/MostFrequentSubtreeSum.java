package com.namanh.binary_tree;

import com.namanh.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/most-frequent-subtree-sum
 * Question: Given the root of a binary tree, return the most frequent subtree sum (sum of all the node values formed by
 * the subtree rooted at that node). If there is a tie, return all the values with the highest frequency in any order.
 * S1: Use DFS to calculate subtree sum from bottom to top
 * S2: Add frequency of appearance of subtree sum into map, store maximum frequency
 * S3: Get all value have frequency equals maximum frequency
 * S4: Convert result to array
 */
public class MostFrequentSubtreeSum {
    int maxFrequent;
    Map<Integer, Integer> freqMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> maxFreqValue = new ArrayList<>();
        for (Map.Entry<Integer, Integer> freq : freqMap.entrySet()) {
            if (freq.getValue() == maxFrequent) {
                maxFreqValue.add(freq.getKey());
            }
        }
        int size = maxFreqValue.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = maxFreqValue.get(i);
        }
        return arr;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = node.left == null ? 0 : dfs(node.left);
        int right = node.right == null ? 0 : dfs(node.right);
        node.val += left + right;
        int freq = freqMap.getOrDefault(node.val, 0) + 1;
        if (freq > maxFrequent) maxFrequent = freq;
        freqMap.put(node.val, freq);
        return node.val;
    }
}
