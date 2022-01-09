package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value. If target is not found in the array, return [-1, -1].
 *
 * S1: Search start index nums[start] >= target
 * S2: If nums.length = 0 or nums[start] != target, return [-1, -1]
 * S3: Search end index nums[end] >= target + 1
 * S4: If nums[end] != target, assign end--
 * S5: Return [start, end]
 *
 * Time: O(log(n))
 * Space: O(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = searchIndex(nums, target);
        if (nums.length == 0 || nums[startIndex] != target) return new int[]{-1, -1};

        int endIndex = searchIndex(nums, target + 1);
        if (nums[endIndex] != target) endIndex--;
        return new int[]{startIndex, endIndex};
    }

    private int searchIndex(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
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
