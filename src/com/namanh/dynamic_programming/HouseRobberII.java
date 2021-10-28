package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/house-robber-ii
 * Q: Find the max sum with non-adjacent elements in circle array.
 *
 * ..... a[i-2]  a[i-1]  a[i] .....
 *          |      |
 *          |    max2 -----------> max
 *         max1 -------- a[i] ---> max
 *
 * S1: Break to 2 sub problems a[0...end-1] and a[1...end]
 * S2: To solve sub problem, at a[i], get max(max1 + a[i], max2), set result to max2
 * S3: Return max of 2 sub problems
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robArray(nums, 0, n-2), robArray(nums, 1, n-1));
    }

    private int robArray(int[] nums, int start, int end) {
        int max1 = 0, max2 = 0, tmp;
        for (int i = start; i <= end; i++) {
            tmp = max2;
            max2 = Math.max(max1 + nums[i], max2);
            max1 = tmp;
        }
        return max2;
    }
}
