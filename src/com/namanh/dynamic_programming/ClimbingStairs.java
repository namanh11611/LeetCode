package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/climbing-stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * S1: Use dynamic programming with formula: Step(n) = Step(n-1) + Step(n-2)
 *
 * Time: O(n)
 * Space: O(1)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev1 = 1, prev2 = 2, cur = 3;
        for (int i = 3; i <= n; i++) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
}
