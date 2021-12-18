package com.namanh.binary_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/path-sum
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 *
 * S1: Use recursive approach
 * S2: Each step, get targetSum - current value
 * S3: If current node is leaf and value equal targetSum, return true
 *
 * Time: O(n)
 * Space: O(n)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (targetSum == root.val && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
