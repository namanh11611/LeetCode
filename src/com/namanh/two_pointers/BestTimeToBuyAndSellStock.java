package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your
 * profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 *
 * S1: Iterate prices array
 * S2: Each step, assign result if price - min greater than result
 * S3: Update min if needed
 * S4: Return result
 *
 * Time: O(n)
 * Space: O(1)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(min, price);
        }
        return result;
    }
}
