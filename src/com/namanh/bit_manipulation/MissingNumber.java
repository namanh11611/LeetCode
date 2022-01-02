package com.namanh.bit_manipulation;

/**
 * https://leetcode.com/problems/missing-number
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
 * missing from the array.
 */
public class MissingNumber {
    /**
     * Because i ^ i = 0, so we xor all value 0..n and all value in nums array
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    /**
     * Calculate sum of 0..n and minus all value in nums array
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
