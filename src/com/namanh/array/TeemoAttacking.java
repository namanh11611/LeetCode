package com.namanh.array;

/**
 * https://leetcode.com/problems/teemo-attacking
 * You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at
 * second timeSeries[i], and an integer duration. Return the total number of seconds that Ashe is poisoned.
 *
 * S1: Set end is time when end of attack
 * S2: At time, if time <= end, we minus end - time + 1
 * S3: At time, if time > end, add duration into result
 * S4: Return result
 *
 * Time: O(n)
 * Space: O(1)
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int end = -1;
        for (int time : timeSeries) {
            if (end >= time) {
                result += duration - (end - time + 1);
            } else {
                result += duration;
            }
            end = time + duration - 1;
        }
        return result;
    }
}
