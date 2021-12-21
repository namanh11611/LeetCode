package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/search-insert-position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 *
 * S1: If target > nums[end] return nums.length
 * S2: Use binary search
 *
 * Time: O(log(n))
 * Space: O(1)
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        if (nums[end] < target) return end + 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
