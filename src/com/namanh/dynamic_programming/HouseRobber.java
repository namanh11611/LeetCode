package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/house-robber
 * Q: Find the max sum with non-adjacent elements.
 *
 * ..... a[i-2]  a[i-1]  a[i] .....
 *          |      |
 *          |    max2 -----------> max
 *         max1 -------- a[i] ---> max
 *
 * S1: At a[i], get max(max1 + a[i], max2)
 * S2: Return a[end]
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }
        return nums[n-1];
    }
}
