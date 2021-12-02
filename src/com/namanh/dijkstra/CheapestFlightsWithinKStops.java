package com.namanh.dijkstra;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 *
 * S1: Use Dijkstra
 * S2: We don't use normal dictionary, because we still add edge if price or step smaller than previous value
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adj = new int[n][n];
        for (int[] flight : flights) {
            adj[flight[0]][flight[1]] = flight[2];
        }

        int[] minPrice = new int[n];
        int[] minStep = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        Arrays.fill(minStep, Integer.MAX_VALUE);

        Queue<int[]> edge = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        edge.offer(new int[]{src, 0, k + 1});
        while (!edge.isEmpty()) {
            int[] info = edge.poll();
            int city = info[0];
            int price = info[1];
            int numK = info[2];

            if (city == dst) return price;
            if (numK == 0) continue;

            for (int c2 = 0; c2 < n; c2++) {
                if (adj[city][c2] > 0) {
                    int price2 = adj[city][c2];
                    int numK2 = numK - 1;

                    if (price + price2 < minPrice[c2]) {
                        minPrice[c2] = price + price2;
                        edge.offer(new int[]{c2, minPrice[c2], numK2});
                    } else if (numK2 > minStep[c2]) {
                        edge.offer(new int[]{c2, price + price2, numK2});
                    }
                    minStep[c2] = numK2;
                }
            }

        }
        return -1;
    }
}
