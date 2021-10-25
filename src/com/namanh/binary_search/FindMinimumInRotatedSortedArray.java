package com.namanh.binary_search;

/**
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 * Question: Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * S1: If number middle < first number -> search in left
 * S2: If number middle > first number -> search in right
 * S3: Return when start equals middle (start == end OR start == end -1)
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n-1]) return nums[0];
        return findMinByIndex(nums, 0, n - 1);
    }

    private int findMinByIndex(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start == mid) return Math.min(nums[start], nums[end]);
        if (nums[mid] < nums[0]) {
            return findMinByIndex(nums, start, mid);
        } else {
            return findMinByIndex(nums, mid, end);
        }
    }
}
