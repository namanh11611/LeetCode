package com.namanh.sort;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int temp;
        int i = 0, k = 1;
        while (i < n && k < n) {
            while ((nums[i] & 1) == 0) {
                i += 2;
                if (i >= n) return nums;
            }
            while ((nums[k] & 1) == 1) {
                k += 2;
                if (k > n) return nums;
            }
            temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
