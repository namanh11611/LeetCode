package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/binary-search
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 * target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * S1: Use binary search template
 *
 * Time: O(log(n))
 * Space: O(1)
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
