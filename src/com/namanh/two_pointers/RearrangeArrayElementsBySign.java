package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 * - Every consecutive pair of integers have opposite signs.
 * - For all integers with the same sign, the order in which they were present in nums is preserved.
 * - The rearranged array begins with a positive integer.
 *
 * S1: Iterate array
 * S2: If num > 0, push it to even index
 * S3: If num < 0, push it to odd index
 *
 * Time: O(n)
 * Space: O(n)
 */
public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, posIdx = 0, negIdx = 1;
        int[] result = new int[n];
        for (int num : nums) {
            if (num > 0) {
                result[posIdx] = num;
                posIdx += 2;
            } else {
                result[negIdx] = num;
                negIdx += 2;
            }
        }
        return result;
    }
}
