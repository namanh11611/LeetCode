package com.namanh.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 *
 * S1: Add all intervals before newInterval
 * S2: Merge all intervals in range of newInterval
 * S3: Add all remain intervals
 *
 * Time: O(n)
 * Space: O(n)
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();

        // Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all intervals in range of newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all remain intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}
