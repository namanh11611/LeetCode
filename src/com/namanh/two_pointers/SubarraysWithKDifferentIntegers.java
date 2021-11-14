package com.namanh.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 * Given an integer array nums and an integer k, return the number of subarrays, which have the number of different
 * integers in that array is exactly k.
 *
 * S1: Use result from Longest subarray with at most k distinct integer
 * S2: Subarray exactly K = At most K - At most K-1
 *
 * Time: O(n)
 * Space: O(n)
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k)
                - subarraysWithAtMostKDistinct(nums, k - 1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int start = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            while (freq.size() > k) {
                int tmp = nums[start];
                int fTmp = freq.get(tmp);
                if (fTmp == 1) {
                    freq.remove(tmp);
                } else {
                    freq.put(tmp, fTmp - 1);
                }
                start++;
            }
            result += i - start + 1;
        }
        return result;
    }
}
