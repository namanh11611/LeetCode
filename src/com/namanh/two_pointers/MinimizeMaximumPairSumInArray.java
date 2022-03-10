package com.namanh.two_pointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 * - Each element of nums is in exactly one pair, and
 * - The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 *
 * S1: Sort array
 * S2: Pair from head and tail of array, find max sum
 *
 * Time: O(n * log(n))
 * Space: O(1)
 */
public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            sum = Math.max(sum, nums[i] + nums[n-i-1]);
        }
        return sum;
    }
}
