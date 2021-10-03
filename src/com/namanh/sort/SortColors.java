package com.namanh.sort;

/**
 * https://leetcode.com/problems/sort-colors
 */
public class SortColors {

    // Cach 1: 37.2 MB
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            switch (nums[i]) {
                case 0 -> num0++;
                case 1 -> num1++;
                case 2 -> num2++;
            }
        }
        n--;
        while (num0 > 0 || num1 > 0 || num2 > 0) {
            if (num2-- > 0) {
                nums[n--] = 2;
                continue;
            }
            if (num1-- > 0) {
                nums[n--] = 1;
                continue;
            }
            if (num0-- > 0) nums[n--] = 0;
        }
    }

    // Cach 2: 37.3 MB
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int bound = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i != bound) {
                    nums[i] = nums[bound];
                    nums[bound] = 0;
                }
                bound++;
            }
        }
        bound = n-1;
        for (int j = n-1; j >= 0; j--) {
            if (nums[j] == 0) break;
            if (nums[j] == 2) {
                if (j != bound) {
                    nums[j] = nums[bound];
                    nums[bound] = 2;
                }
                bound--;
            }
        }
    }
}
