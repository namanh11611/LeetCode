package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once.
 *
 *     1   1   1   2   2   3
 *   slow        fast
 * S1: Run fast until nums[fast] > nums[slow]
 * S2: Set nums[slow+1] is nums[fast]
 *
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int slow = 0, fast = 0;
        while (true) {
            while (nums[fast] == nums[slow]) {
                if (++fast == n) return slow + 1;
            }
            nums[++slow] = nums[fast];
        }
    }
}
