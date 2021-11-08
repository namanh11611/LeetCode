package com.namanh.array;

/**
 * https://leetcode.com/problems/max-consecutive-ones
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * S1: Count number 1 element, compare and set max
 * S2: Reset count when meet 0
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
