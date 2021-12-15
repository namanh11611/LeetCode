package com.namanh.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters
 * A string is good if there are no repeated characters. Given a string s, return the number of good substrings of
 * length three in s.
 */
public class SubstringsOfSizeThreeWithDistinctCharacters {
    // Simple
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);
            if (c1 != c2 && c2 != c3 && c3 != c1) {
                count++;
            }
        }
        return count;
    }

    // General
    public int countGoodSubstrings2(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (i >= 3) {
                char oldC = s.charAt(i - 3);
                map.put(oldC, map.get(oldC) - 1);
                if (map.get(oldC) == 0) {
                    map.remove(oldC);
                }
            }
            if (map.size() == 3) count++;
        }

        return count;
    }
}
