package com.namanh.sort;

/**
 * https://leetcode.com/problems/move-zeroes
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int bound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != bound) {
                    nums[bound] = nums[i];
                    nums[i] = 0;
                }
                bound++;
            }
        }
    }
}
