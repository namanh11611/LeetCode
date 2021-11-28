package com.namanh.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/path-with-maximum-probability
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and
 * return its success probability.
 */
public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            adj.get(a).add(new int[]{b, i});
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(b).add(new int[]{a, i});
        }

        Set<Integer> dict = new HashSet<>();

        double[] prob = new double[n];
        prob[start] = 1.0d;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(prob[b], prob[a]));
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) return prob[cur];

            if (dict.contains(cur)) continue;
            dict.add(cur);

            List<int[]> adjVer = adj.getOrDefault(cur, new ArrayList<>());
            for (int[] ver : adjVer) {
                int v = ver[0];
                double p = prob[cur] * succProb[ver[1]];
                if (p > prob[v]) {
                    prob[v] = p;
                    queue.offer(v);
                }
            }
        }
        return 0;
    }
}
