package com.namanh.array;

/**
 * Link: https://leetcode.com/problems/bulb-switcher-iii
 * Question: There is a room with n bulbs, a bulb changes color to blue only if it is on and all the previous bulbs
 * (to the left) are turned on too. Return the number of moments in which all turned-on bulbs are blue.
 * S1: Count when max value equals total number bulb turned on
 */
public class BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        int maxValue = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (light[i] > maxValue) {
                maxValue = light[i];
            }
            if (maxValue == i + 1) result++;
        }
        return result;
    }
}
