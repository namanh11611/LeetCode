package com.namanh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 *
 * S1: Sort array by first element
 * S2: When merging each element, compare previous[1] with current[0] to decide add interval or not
 * S3: If we can't add interval, continue compare previous[1] with current[1] to update the second element
 * S4: Add last interval
 * S5: Convert ArrayList to array
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        int[] prev = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                result.add(prev);
                prev = cur;
            } else if (prev[1] < cur[1]) {
                prev[1] = cur[1];
            }
        }
        result.add(prev);

        return result.toArray(new int[result.size()][2]);
    }
}
