package com.namanh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/make-sum-divisible-by-p
 * Question: Remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p
 * S1: Calculate prefix sum, save remain value when divide p
 *     NOTE: prefix sum maybe overflow, so we only save remain
 * S2: Calculate expect remain to remove sub array (= current - remainSum)
 * S3: Get position from map, calculate length (= i - pos) and assign to result if it is smaller
 * S4: Put current remain into map
 */
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = i == 0 ? nums[i] : nums[i-1] + nums[i];
            nums[i] = sum % p;
        }
        int remainSum = nums[n-1] % p;
        if (remainSum == 0) return 0;

        int result = n;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            int expectRemain = nums[i] < remainSum ? nums[i] + p - remainSum : nums[i] - remainSum;
            if (sumMap.containsKey(expectRemain)) {
                int expectPos = sumMap.get(expectRemain);
                if (i - expectPos < result) {
                    result = i - expectPos;
                }
            }
            sumMap.put(nums[i], i);
        }
        return result == n ? -1 : result;
    }
}
