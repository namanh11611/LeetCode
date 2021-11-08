package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
 * that they add up to a specific target number.
 *
 * S1: Use two pointer
 * S2: Browser from head and tail of array
 *
 * Time: O(n)
 * Space: O(1)
 */
public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[2];
    }
}
