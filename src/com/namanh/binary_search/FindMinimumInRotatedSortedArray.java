package com.namanh.binary_search;

/**
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 * Question: Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * S1: Use binary search template
 * S2: If number middle < first number -> search in left
 * S3: If number middle > first number -> search in right
 * S4: Return nums[start] when start equals end
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[0] < nums[end]) return nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[0]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
