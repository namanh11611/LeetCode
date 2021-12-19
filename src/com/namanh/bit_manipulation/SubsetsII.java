package com.namanh.bit_manipulation;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * S1: Sort array
 * S2: Use set to store result
 * S3: If array has n elements, we will have 2^n subsets
 * S4: Each subset, index is bitmask of appearance (ex: 100, 010, 001...)
 *
 * Time: O(n * 2^n)
 * Space: O(n * 2^n)
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        int numSubset = 1 << n;
        for (int i = 0; i < numSubset; i++) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                if (((i >> k) & 1) == 1) list.add(nums[k]);
            }
            set.add(list);
        }
        return new ArrayList<>(set);
    }
}
