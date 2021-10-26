package com.namanh.array;

/**
 * Link: https://leetcode.com/problems/rotate-array
 * Question: rotate the array to the right by k steps.
 *      1 2 3 4 5 6    --->    6 5    4 3 2 1
 *                            \   /  \       /
 *                             ---    ------
 *                            /   \  /       \
 *                     --->    5 6    1 2 3 4
 * S1: k mod n to get minimum k
 * S2: Reverse all elements
 * S3: Reverse 0...k-1
 * S4: Reverse k...n-1 (because a[0] move to a[k])
 */
public class RotateArray {
    // O(1) space approach
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }


    // Brute-force approach
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            int newId = i + k;
            while (newId >= n) {
                newId -= n;
            }
            newArr[newId] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
