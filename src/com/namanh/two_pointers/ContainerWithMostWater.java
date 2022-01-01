package com.namanh.two_pointers;

/**
 * https://leetcode.com/problems/container-with-most-water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container, such that
 * the container contains the most water. Return the maximum amount of water a container can store.
 *
 * S1: Use 2 pointers move from start and end
 * S2: Calculate and update result if needed
 * S3: Move pointer that is min value
 *
 * Time: O(n)
 * Space: O(1)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            result = Math.max(result, (right - left) * minHeight);

            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (right > left && height[right] <= minHeight) {
                right--;
            }
        }
        return result;
    }
}
