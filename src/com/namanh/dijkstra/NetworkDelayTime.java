package com.namanh.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/network-delay-time
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it
 * is impossible for all the n nodes to receive the signal, return -1.
 *
 * S1: Create map of adjacent verticals
 * S2: Implement Dijkstra algorithm to find max duration
 * S3: If number of visited node not equals n, return -1
 *
 * Time: O(n^2 + edge)
 * Space: O(n + edge)
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            if (!adj.containsKey(time[0])) {
                adj.put(time[0], new ArrayList<>());
            }
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int maxDur = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(ver -> ver[1]));
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ver = cur[0];
            int dis = cur[1];
            if (visited.contains(ver)) continue;

            visited.add(ver);
            maxDur = Math.max(maxDur, dis);

            List<int[]> adjVer = adj.getOrDefault(ver, new ArrayList<>());
            for (int[] v : adjVer) {
                if (!visited.contains(v[0])) {
                    queue.offer(new int[]{v[0], dis + v[1]});
                }
            }
        }

        if (visited.size() != n) return -1;
        return maxDur;
    }
}
