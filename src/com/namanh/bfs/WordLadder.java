package com.namanh.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-ladder
 * Q: Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * S1: Get index of endWord
 * S2: Convert wordList to Map, key is index, value is list of adjacent word
 * S3: Use BFS to visit all word, stop when meet endWord index
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int endId = -1;
        int[] visited = new int[n + 1];
        Map<Integer, List<Integer>> mapWord = new HashMap<>();
        List<Integer> adjBegin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String first = wordList.get(i);
            if (isAdjacent(beginWord, first)) {
                adjBegin.add(i);
            }
            if (first.equals(endWord)) {
                endId = i;
            }

            List<Integer> adjList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String second = wordList.get(j);
                if (i != j && isAdjacent(first, second)) {
                    adjList.add(j);
                }
            }
            mapWord.put(i, adjList);
        }
        if (endId < 0) return 0;
        mapWord.put(n, adjBegin);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            List<Integer> curAdjIndex = mapWord.get(curIndex);
            for (Integer index : curAdjIndex) {
                if (index == endId) return visited[curIndex] + 1;
                if (visited[index] == 0) {
                    queue.offer(index);
                    visited[index] = visited[curIndex] + 1;
                }
            }
        }
        return 0;
    }

    private boolean isAdjacent(String first, String second) {
        int length = first.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
