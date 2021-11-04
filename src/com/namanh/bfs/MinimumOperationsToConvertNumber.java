package com.namanh.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-convert-number
 * Q: Return the minimum number of operations needed to convert x = start into goal, and -1 if it is not possible.
 *
 * S1: Use BFS to visit all nodes
 * S2: Get value from queue, return if equals goal
 * S3: If 0 <= value <= 1000 and not exist in Set, add it to Set
 * S4: Add all result from calculation to Queue
 * S5: Back to S2
 *
 * Time complexity: O(1000) because we only visit maximum 1000 nodes
 */
public class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> curSet = new HashSet<>();
        int result = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int cur = queue.poll();
                if (cur == goal) {
                    return result;
                }
                if (cur >= 0 && cur <= 1000 && !curSet.contains(cur)) {
                    curSet.add(cur);
                    for (int num : nums) {
                        queue.offer(cur + num);
                        queue.offer(cur - num);
                        queue.offer(cur ^ num);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
