package com.namanh.quick_select;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin
 * B1: Calculate distance array
 * B2: Apply quick sort by descending for distance array
 * B2.1: If pivot < k-1, continue quick sort right array
 * B2.2: If pivot > k-1, continue quick sort left array
 * B2.3: If pivot == k-1, return left right
 */
public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        int pivot;
        int start = 0, end = n - 1;
        do {
            pivot = quickSelect(points, dis, start, end);
            if (pivot < k - 1) {
                start = pivot + 1;
            } else if (pivot > k - 1) {
                end = pivot - 1;
            }
        } while (pivot != k - 1);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private int quickSelect(int[][] points, int[] dis, int start, int end) {
        int smallItemId = start;
        int temp;
        int[] tmpPoint;
        for (int i = start; i < end; i++) {
            if (dis[i] < dis[end]) {
                if (i != smallItemId) {
                    temp = dis[i];
                    dis[i] = dis[smallItemId];
                    dis[smallItemId] = temp;

                    tmpPoint = points[i];
                    points[i] = points[smallItemId];
                    points[smallItemId] = tmpPoint;
                }
                smallItemId++;
            }
        }
        temp = dis[end];
        dis[end] = dis[smallItemId];
        dis[smallItemId] = temp;

        tmpPoint = points[end];
        points[end] = points[smallItemId];
        points[smallItemId] = tmpPoint;
        return smallItemId;
    }
}
