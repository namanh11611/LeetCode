package com.namanh.divide_and_conquer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-nice-substring
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * Given a string s, return the longest substring of s that is nice.
 */
public class LongestNiceSubstring {
    /**
     * Divide and Conquer approach (/dɪˈvaɪd/ /ˈkɑːŋkər/)
     */
    public String longestNiceSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                String sub1 = longestNiceSubstring(s.substring(0, i));
                String sub2 = longestNiceSubstring(s.substring(i + 1));
                if (sub1.length() >= sub2.length()) {
                    return sub1;
                } else {
                    return sub2;
                }
            }
        }
        return s;
    }

    /**
     * Brute-force approach
     */
    public String longestNiceSubstring2(String s) {
        int start = 0;
        int maxLength = 0, curLength;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Map<Integer, Boolean> map = new HashMap<>();
            int numDist = 0, numCouple = 0;
            curLength = 0;
            for (int j = i; j < n; j++) {
                int c = s.charAt(j);
                if (map.containsKey(c - 32)) {
                    if (!map.get(c - 32)) {
                        numCouple++;
                    }
                    map.put(c - 32, true);
                } else if (map.containsKey(c + 32)) {
                    if (!map.get(c + 32)) {
                        numCouple++;
                    }
                    map.put(c + 32, true);
                } else {
                    if (!map.containsKey(c)) {
                        numDist++;
                    }
                    map.putIfAbsent(c, false);
                }
                curLength++;
                if (curLength > maxLength && numDist == numCouple) {
                    maxLength = curLength;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
