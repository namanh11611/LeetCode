package com.namanh.minimum_spanning_tree;

import java.util.*;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|.
 * Return the minimum cost to make all points connected.
 *
 * S1: Use Kruskal algorithm
 * S2: Create Point and Edge, save all edges into priority queue
 * S3: Get each edge and add it into Minimum spanning tree until number edge is n-1
 * S4: Use union find to merge point
 *
 * Time: O(n^2 * log(n))
 * Space: O(n^2)
 *
 * TODO: Optimize root array
 */
public class MinCostToConnectAllPoints {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p) {
            return x == p.x && y == p.y;
        }
    }

    class Edge {
        Point p1;
        Point p2;

        Edge(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        int getDistance() {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<Point> pList = new ArrayList<>();
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
        Map<Point, Point> root = new HashMap<>(); // Optimize root array
        int n = points.length;
        for (int[] p : points) {
            Point newP = new Point(p[0], p[1]);
            pList.add(newP);
            root.put(newP, newP);
        }

        for (int i = 0; i < n; i++) {
            Point pi = pList.get(i);
            for (int j = i + 1; j < n; j++) {
                Point pj = pList.get(j);
                edges.offer(new Edge(pi, pj));
            }
        }

        int count = 0;
        int result = 0;
        while (!edges.isEmpty() && count < n-1) {
            Edge e = edges.poll();
            Point pRoot1 = findRoot(root, e.p1);
            Point pRoot2 = findRoot(root, e.p2);

            if (!pRoot1.equals(pRoot2)) {
                root.put(pRoot1, pRoot2);
                result += e.getDistance();
                count++;
            }
        }

        return result;
    }

    private Point findRoot(Map<Point, Point> root, Point cur) {
        root.putIfAbsent(cur, cur);
        Point r = root.get(cur);
        if (!r.equals(cur)) {
            root.put(cur, findRoot(root, r));
        }
        return root.get(cur);
    }
}
