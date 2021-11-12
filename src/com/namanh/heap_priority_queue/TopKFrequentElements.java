package com.namanh.heap_priority_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any
 * order.
 *
 * S1: Use Map to create frequently map of each element
 * S2: Use Priority Queue to sort frequently -> it takes O(n * log(n))
 * S3: Create array to return result
 *
 * Time: O(n * log(n))
 * Space: O(n)
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        for (int num : map.keySet()) {
            queue.offer(num);
        }
        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            result[index++] = queue.poll();
        }
        return result;
    }
}
