package com.namanh.dynamic_programming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you
 * can either climb one or two steps. You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 *
 * S1: Change cost[i] to min sum of path if end at index i
 * S2: Formula cost[i] = min(cost[i-2], cost[i-1]) + cost[i]
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[n-2], cost[n-1]);
    }
}
