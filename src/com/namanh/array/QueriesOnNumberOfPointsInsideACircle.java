package com.namanh.array;

/**
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle
 * You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane.
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a
 * radius of rj. For each query queries[j], compute the number of points inside the jth circle.
 * Return an array answer, where answer[j] is the answer to the jth query.
 *
 * S1: Each query, iterate through all points and calculate distance
 * S2: If distance less than radius, increase answer
 *
 * Time: O(n * q)
 * Space: O(q)
 */
public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int qLength = queries.length;
        int[] answer = new int[qLength];
        for (int i = 0; i < qLength; i++) {
            int radius = queries[i][2] * queries[i][2];
            int x = queries[i][0];
            int y = queries[i][1];
            for (int[] point : points) {
                int dis = (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]);
                if (dis <= radius) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
