package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/combination-sum-iv
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that
 * add up to target.
 *
 * S1: Use dp bottom-up
 * S2: Create an array with size equal target + 1 to store dp value
 * S3: Each step, iterate nums array, add value of dp[i-num] into dp[i]
 * S4: Return dp[target]
 *
 * Time: O(target * n)
 * Space: O(target)
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int max = target + 1;
        int[] dp = new int[max];
        dp[0] = 1;
        for (int i = 1; i < max; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
