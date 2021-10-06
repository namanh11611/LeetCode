package com.namanh.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        Map<Integer, Integer> mapSum = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            sum[i] = i == 0 ? 0 : sum[i-1] + nums[i-1];
            int minSum = sum[i] - k;
            if (mapSum.containsKey(minSum)) {
                int numberMinSum = mapSum.get(minSum);
                count += numberMinSum;
            }
            int numberSum = mapSum.getOrDefault(sum[i], 0);
            mapSum.put(sum[i], ++numberSum);
        }
        return count;
    }
}
