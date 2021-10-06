package com.namanh.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs
 */
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int expectVal = k - num;
            if (map.containsKey(expectVal)) {
                int numberExpect = map.get(expectVal);
                if (numberExpect == 1) {
                    map.remove(expectVal);
                } else {
                    map.put(expectVal, --numberExpect);
                }
                count++;
            } else {
                int number = map.getOrDefault(num, 0);
                map.put(num, ++number);
            }
        }
        return count;
    }
}
