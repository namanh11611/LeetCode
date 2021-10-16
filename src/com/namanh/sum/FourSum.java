package com.namanh.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/4sum
 * Similar 3sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return new ArrayList<>();

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int l = map.getOrDefault(target - nums[i] - nums[j] - nums[k], k);
                    if (l > k) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
