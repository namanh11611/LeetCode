package com.namanh.sum;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expectVal = target - nums[i];
            if (map.containsKey(expectVal)) {
                return new int[]{map.get(expectVal), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
