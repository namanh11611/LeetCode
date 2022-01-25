package com.namanh.binary_tree;

import com.namanh.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
 * values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * S1: Use recursive find path in left and right child
 * S2: Check if current node is leaf and sum equal 0, add current path into result
 *
 * Time: O(n)
 * Space: O(n)
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> path = new ArrayList<>();
        findPath(path, new ArrayList<>(), root, targetSum);
        return path;
    }

    private void findPath(List<List<Integer>> path, List<Integer> curPath, TreeNode node, int sum) {
        if (node == null) return;

        curPath.add(node.val);
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            path.add(curPath);
            return;
        }
        findPath(path, new ArrayList<>(curPath), node.left, sum);
        findPath(path, new ArrayList<>(curPath), node.right, sum);
    }
}
