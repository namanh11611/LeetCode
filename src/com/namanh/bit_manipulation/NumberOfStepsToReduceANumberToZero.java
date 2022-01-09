package com.namanh.bit_manipulation;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToReduceANumberToZero {
    /**
     * Count bit approach
     * If even, do 1 step
     * If odd, do 2 steps
     */
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int result = 0;
        while (num > 0) {
            result += (num & 1) + 1;
            num >>= 1;
        }
        return --result;
    }

    /**
     * Normal approach
     */
    public int numberOfSteps2(int num) {
        int result = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num >>= 1;
            }
            result++;
        }
        return result;
    }
}
