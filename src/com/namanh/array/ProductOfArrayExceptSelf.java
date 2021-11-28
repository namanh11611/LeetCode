package com.namanh.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * S1: Create result array with all values equals 1
 * S2: Use 2 pointer left and right
 *
 * Time: O(n)
 * Space: O(n)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            result[n-i-1] *= right;
            left *= nums[i];
            right *= nums[n-i-1];
        }
        return result;
    }
}
