package com.namanh.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/sum-of-unique-elements
 * Question: Return the sum of all the unique elements of nums. The unique elements of an array are the elements that
 * appear exactly once in the array.
 * S1: Save frequently of appearance into Map
 * S2: Get unique number and add into sum
 */
public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int num : nums) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }
}
