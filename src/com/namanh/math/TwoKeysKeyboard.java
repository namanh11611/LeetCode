package com.namanh.math;

/**
 * https://leetcode.com/problems/2-keys-keyboard
 * There is only one character 'A' on the screen. You can perform two operations for each step:
 * - Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * - Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 *
 * Assume perform operation CPP CPPP CPPPP...
 * Number of each group operation is factor of n: num1, num2, num3...
 * Because after perform all operation, result is num1 * num2 * num3 character 'A'
 * So we need find sum of prime factor of n
 *
 * S1: Each step, check if i is prime factor of n
 * S2: Calculate sum
 * S3: Set n equal n divide i
 *
 * Time: O(sqrt(n))
 * Space: O(1)
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                result += i;
                n /= i;
            }
        }
        return result;
    }
}
