package com.namanh.union_find;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/graph-connectivity-with-threshold
 * Given the two integers, n and threshold, and an array of queries, you must determine for each queries[i] = [ai, bi]
 * if cities ai and bi are connected directly or indirectly.
 *
 * S1: Build union find parent array
 * S2: Start from threshold + 1, merge i and it's multiples, use path compression
 * S3: Check root of 2 elements in query
 *
 * Time: O(n * log(n) + q)
 * Space: O(n)
 */
public class GraphConnectivityWithThreshold {
    int[] parent;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            int divisor = i;
            int curRoot = findRoot(i);
            while (divisor <= n) {
                int divRoot = findRoot(divisor);
                parent[divRoot] = curRoot;
                divisor += i;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(findRoot(query[0]) == findRoot(query[1]));
        }
        return result;
    }

    private int findRoot(int a) {
        if (parent[a] != a) {
            parent[a] = findRoot(parent[a]);
        }
        return parent[a];
    }
}
