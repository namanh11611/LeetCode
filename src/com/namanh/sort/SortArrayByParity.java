package com.namanh.sort;

/**
 * https://leetcode.com/problems/sort-array-by-parity
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int bound = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 0) {
                if (i != bound) {
                    temp = nums[bound];
                    nums[bound] = nums[i];
                    nums[i] = temp;
                }
                bound++;
            }
        }
        return nums;
    }
}
