package com.namanh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/subarray-sums-divisible-by-k
 * Question: Find the number of non-empty subarrays that have a sum divisible by k.
 * S1: Create prefix sum
 * S2: Find remain when prefix sum divide k, if remain < 0, set remain += k
 * S3: Get frequency of appearance remain in map, add on result
 * S4: Increase frequency of appearance remain in map
 */
public class SubArraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainMap = new HashMap<>();
        remainMap.put(0, 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            nums[i] += i == 0 ? 0 : nums[i-1];
            int remain = nums[i] % k;
            if (remain < 0) remain += k;
            int frequency = remainMap.getOrDefault(remain, 0);
            result += frequency;
            remainMap.put(remain, ++frequency);
        }
        return result;
    }
}
