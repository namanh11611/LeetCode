package com.namanh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/subarray-sum-equals-k
 * Question: Find the total number of continuous subarrays whose sum equals to k.
 * S1: Use Map to save prefix sum
 * S2: Iterate the array, calculate current prefix sum
 * S3: Get frequency of appearance of currentSum - k, add on result
 * S4: Put currentSum into map, value is frequency of appearance
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mapSum = new HashMap<>();
        mapSum.put(0, 1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            nums[i] += i == 0 ? 0 : nums[i-1];
            count += mapSum.getOrDefault(nums[i] - k, 0);
            mapSum.put(nums[i], mapSum.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
