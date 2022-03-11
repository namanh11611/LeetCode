package com.namanh.two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears
 * in at most one part. Return a list of integers representing the size of these parts.
 *
 * S1: Use an array has size 26 to store last index of each character
 * S2: Iterate string s and find the last index of each partition, separate when meet last index equal current index
 *
 * Time: O(n)
 * Space: O(1)
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int[] lastIdx = new int[26];
        for (int i = 0; i < n; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        int index = 0;
        while (index < n) {
            int startIdx = index;
            int endIdx = lastIdx[s.charAt(index) - 'a'];
            while (index != endIdx) {
                index++;
                endIdx = Math.max(endIdx, lastIdx[s.charAt(index) - 'a']);
            }
            result.add(index - startIdx + 1);
            index++;
        }
        return result;
    }
}
