package com.namanh.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-stones
 * Choose two different non-empty piles, take one stone from each, until there are fewer than two non-empty piles.
 * Given three integers a, b, and c, return the maximum score you can get.
 */
public class MaximumScoreFromRemovingStones {

    /**
     * S1: Assume a <= b <= c
     * S2: If a + b <= c, we can take maximum a + b
     * S3: If a + b > c, divide c to c1 and c2, a - c1 ~ b - c2
     *     -> c1 = (c - b + a)/2, c2 = (c + b - a)/2
     *     First, we take c1 with a
     *     Second, we take c2 with b
     *     Final, we take a - c1
     *     => Result = c + (a - c1) = (a + b + c)/2
     */
    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        if (arr[0] + arr[1] <= arr[2]) {
            return arr[0] + arr[1];
        } else {
            return (arr[0] + arr[1] + arr[2]) >> 1;
        }
    }

    /**
     * S1: Add all elements into PriorityQueue
     * S2: Poll 2 element, decrease 1 and put it back to queue
     * S3: Stop when 2 elements equals 0 (note that a always > b)
     */
    public int maximumScore2(int a, int b, int c) {
        int score = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(a);
        queue.offer(b);
        queue.offer(c);
        do {
            a = queue.poll() - 1;
            b = queue.poll() - 1;
            c = queue.poll();
            score++;
            queue.offer(a);
            queue.offer(b);
            queue.offer(c);
        } while (a + b > 0 && b + c > 0);
        return score;
    }
}
