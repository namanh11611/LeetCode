package com.namanh.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii
 * B1: Iterate nums1 and nums2 => create map sum
 * B2: Iterate nums3 and nums4 => check expect value
 */
public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int key = num1 + num2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                result += map.getOrDefault(-num3 - num4, 0);
            }
        }
        return result;
    }
}
