package com.namanh.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'. Given the
 * two gene strings start and end and the gene bank, return the minimum number of mutations needed to mutate from
 * start to end. If there is no such a mutation, return -1.
 *
 * S1: Use BFS to visit all string in bank
 * S2: Push start to queue
 * S3: When pop string from queue, push it to set if it isn't visited
 * S4: Change a char and check if bank contains it, add to queue
 * S5: Increase result
 *
 * Time: O(3^8 * 10)
 *      3 is {'A', 'C', 'G', 'T'}.length - 1
 *      8 is length of gen string
 *      10 is length of bank
 * Space: O(3^8)
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] gen = new char[]{'A', 'C', 'G', 'T'};
        int result = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return result;
                }
                if (!set.contains(cur)) {
                    set.add(cur);
                    for (int j = 0; j < 8; j++) {
                        for (char c : gen) {
                            if (cur.charAt(j) != c) {
                                StringBuilder builder = new StringBuilder(cur);
                                builder.setCharAt(j, c);
                                String newStr = builder.toString();
                                for (String bankStr : bank) {
                                    if (bankStr.equals(newStr)) {
                                        queue.offer(newStr);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
