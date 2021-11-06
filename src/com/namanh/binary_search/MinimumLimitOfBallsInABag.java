package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer
 * maxOperations. You can divide bag at most maxOperations times. Your penalty is the maximum number of balls in a bag.
 * Return the minimum possible penalty after performing the operations.
 *
 * S1: Give a boundary and check if it is possible to divide bag with at most maxOperations
 * S2: Min bound is 1, max bound is max value of nums
 * S3: If bag have n ball, number operations is (n - 1) / bound
 * S4: Use binary search, return low
 *
 * Time: O(n * log(maxValue))
 * Space: O(1)
 */
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = 1;
        int mid;
        for (int num : nums) {
            hi = Math.max(hi, num);
        }
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (checkMaxPenalty(nums, mid, maxOperations)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean checkMaxPenalty(int[] nums, int k, int maxOperations) {
        for (int num : nums) {
            maxOperations -= (num - 1) / k;
            if (maxOperations < 0) return false;
        }
        return maxOperations >= 0;
    }
}
