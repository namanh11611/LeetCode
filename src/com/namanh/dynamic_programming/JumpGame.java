package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/jump-game
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
 * array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * S1: Init max index can to jump
 * S2: If current index > max index, return false
 * S3: Return true
 *
 * Time: O(n)
 * Space: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
