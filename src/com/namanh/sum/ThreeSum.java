package com.namanh.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/3sum
 * Question: return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0. Notice that the solution set must not contain duplicate triplets.
 * S1: Sort array to avoid duplicate triplets
 * S2: Create a map to save array
 * S3: Calculate sum of 2 elements and find expect value in map
 * S4: Use Set to save result
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = map.getOrDefault(-nums[i] - nums[j], j);
                if (k > j) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(result);
    }
}
