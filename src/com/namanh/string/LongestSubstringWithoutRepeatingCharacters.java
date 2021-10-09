package com.namanh.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
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
