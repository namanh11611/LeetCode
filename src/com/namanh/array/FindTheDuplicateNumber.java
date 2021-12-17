package com.namanh.array;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 *
 * S1: Use Floyd's Tortoise and Hare (Cycle Detection) algorithm
 * S2: Each step, we set value is 0
 * S3: Return value when meet 0
 *
 * Time: O(n)
 * Space: O(1)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int index = nums[0];
        int cur;
        while (nums[index] > 0) {
            cur = nums[index];
            nums[index] = 0;
            index = cur;
        }
        return index;
    }
}
