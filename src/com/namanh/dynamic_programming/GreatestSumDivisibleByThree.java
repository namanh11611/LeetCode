package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is
 * divisible by three.
 *
 * S1: Create an array with size n * 3 to store max sum with remain equal 0, 1, 2 when divide 3
 * S2: Assign nums[0] for first element
 * S3: Each step, assign previous dp to current dp: dp[i][j] = dp[i - 1][j]
 * S4: Find previous index by remain of nums[i] divide 3, assign sum equal sum of previous dp and nums[i]
 * S5: If sum % 3 = j, and sum greater than current value, assign dp equal sum
 * S6: Return dp[n-1][0]
 *
 * NOTE: array size n * 3
 *
 * Time: O(n)
 * Space: O(n)
 */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        dp[0][nums[0] % 3] = nums[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];

                int prev = (j - (nums[i] % 3) + 3) % 3;
                int sum = dp[i - 1][prev] + nums[i];
                if (sum % 3 == j && sum > dp[i][j]) {
                    dp[i][j] = sum;
                }
            }
        }
        return dp[n-1][0];
    }
}
