package com.namanh.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * S1: Use map to store character and newest index
 * S2: If found a character already in map, calculate length and update max
 *
 * Time: O(n)
 * Space: O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;
        int maxLength = 1;
        int startIndex = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (startIndex < map.getOrDefault(c, -1)) {
                startIndex = map.get(c);
            }
            if (i - startIndex > maxLength) {
                maxLength = i - startIndex;
            }
            map.put(c, i);
        }
        return maxLength;
    }
}
