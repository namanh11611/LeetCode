package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with
 * a value in the inclusive range [low, high].
 *
 * S1: Use recursive approach
 * S2: If current node null, return 0
 * S3: If current value < low, return sum of right child
 * S4: If current value > high, return sum of left child
 * S5: If current value in range [low, high] return sum of current value and sum of 2 children
 *
 * Time: O(n)
 * Space: O(n) because use recursive
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
