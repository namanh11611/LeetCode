package com.namanh.array;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate
 * A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
 * Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location.
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (dis < minDistance) {
                    minDistance = dis;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
