package com.namanh.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-well-performing-interval
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the
 * number of non-tiring days. Return the length of the longest well-performing interval.
 *
 * S1: Convert tiring day to 1, non-tiring day to -1, find the longest sub array have sum is positive
 * S2: Calculate prefix sum
 * S3: If sum is positive, return the length from 0 to current position
 * S4: If sum is non-positive, put it into map, calculate length from sum - 1 to current position
 *
 * Time: O(n)
 * Space: O(n)
 */
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int result = 0;
        int n = hours.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                result = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) {
                    result = Math.max(result, i - map.get(sum - 1));
                }
            }
        }
        return result;
    }
}
