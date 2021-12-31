package com.namanh.dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 * a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return -1.
 *
 * S1: Use dp bottom-up
 * S2: Create array have size equal amount + 1, fill all value with amount + 1
 * S3: Each step, iterate coins array, find min and update current value
 * S4: Return arr[amount]
 *
 * Time: O(n * k)
 * Space: O(n)
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int maxVal = amount + 1;
        int[] arr = new int[maxVal];
        Arrays.fill(arr, maxVal);
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && arr[i-coin] < arr[i] - 1) {
                    arr[i] = arr[i-coin] + 1;
                }
            }
        }
        return arr[amount] == maxVal ? -1 : arr[amount];
    }
}
