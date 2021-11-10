package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all
 * the elements in the subarray is strictly less than k.
 *
 * S1: Calculate product from left to right
 * S2: If product < k, number sub array satisfied is length of current sub array
 * S3: If not, move left pointer until product < k
 *
 * Time: O(n)
 * Space: O(1)
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) return 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int product = 1;
        int counter = 0;
        while (r < n) {
            product *= nums[r];
            while (product >= k && l <= r) {
                product /= nums[l++];
            }
            counter += r - l + 1;
            r++;
        }
        return counter;
    }
}
