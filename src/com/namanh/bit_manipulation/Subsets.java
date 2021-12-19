package com.namanh.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * S1: If array has n elements, we will have 2^n subsets
 * S2: Each subset, index is bitmask of appearance (ex: 100, 010, 001...)
 *
 * Time: O(n * 2^n)
 * Space: O(n * 2^n)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int numSub = 1 << n;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numSub; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                if (((i >> k) & 1) == 1) subList.add(nums[k]);
            }
            result.add(subList);
        }
        return result;
    }
}
