package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * Q: Given the array nums after the possible rotation and an integer target, return the index of target if it is in
 * nums, or -1 if it is not in nums.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            // lo <= mid
            // -- target < lo     -> lo = mid + 1
            // -- target > mid    -> lo = mid + 1
            // lo <= target < mid -> hi = mid - 1
            // lo > mid
            // -- target < mid    -> hi = mid - 1
            // -- target >= lo    -> hi = mid - 1
            // mid < target < lo  -> lo = mid + 1
            if ((nums[lo] <= nums[mid] && (target < nums[lo] || target > nums[mid]))
                    || (target < nums[lo] && target > nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
