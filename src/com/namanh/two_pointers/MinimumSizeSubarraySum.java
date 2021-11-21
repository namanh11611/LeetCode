package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
 * such subarray, return 0 instead.
 *
 * S1: Use right pointer to move until current sum >= target
 * S2: Use left pointer to move until current sum < target
 * S3: In step 2, update min length
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, curSum = 0;
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            while (right < n && curSum < target) {
                curSum += nums[right++];
            }
            while (curSum >= target) {
                result = Math.min(result, right - left);
                curSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
