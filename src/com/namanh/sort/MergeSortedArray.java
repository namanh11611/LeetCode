package com.namanh.sort;

/**
 * https://leetcode.com/problems/merge-sorted-array
 * Merge from right to left
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            nums1[index] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
            index--;
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
