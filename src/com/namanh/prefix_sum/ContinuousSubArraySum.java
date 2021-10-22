package com.namanh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/continuous-subarray-sum
 * Question: return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k,
 * or false otherwise.
 * S1: Convert array to remain of prefix sum divide k
 * S2: Create map save remain with first index
 * S3: Return true when find distance >= 2
 */
public class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainMap = new HashMap<>();
        remainMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            nums[i] += i == 0 ? 0 : nums[i-1];
            nums[i] = nums[i] % k;
            if (remainMap.containsKey(nums[i])) {
                if (i - remainMap.get(nums[i]) >= 2) return true;
            } else {
                remainMap.put(nums[i], i);
            }
        }
        return false;
    }
}
