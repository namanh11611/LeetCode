package com.namanh.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int numSub = (int) Math.pow(2, n);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numSub; i++) {
            List<Integer> subList = new ArrayList();
            for (int k = 0; k < n; k++) {
                if (((i >> k) & 1) == 1) subList.add(nums[k]);
            }
            result.add(subList);
        }
        return result;
    }
}
