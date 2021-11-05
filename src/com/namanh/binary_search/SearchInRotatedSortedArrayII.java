package com.namanh.binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 * Q: Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it
 * is not in nums.
 *
 * S1: Similar previous problem
 * S2: When nums[low] == nums[mid], increase low to remove duplicate elements
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;

            // lo < mid
            // -- target < lo     -> lo = mid + 1
            // -- target > mid    -> lo = mid + 1
            // lo <= target < mid -> hi = mid - 1
            // lo > mid
            // -- target < mid    -> hi = mid - 1
            // -- target >= lo    -> hi = mid - 1
            // mid < target < lo  -> lo = mid + 1
            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }
            if ((nums[lo] < nums[mid] && (target < nums[lo] || target > nums[mid]))
                    || (target < nums[lo] && target > nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
