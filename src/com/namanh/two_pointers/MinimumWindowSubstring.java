package com.namanh.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty
 * string "".
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output:             "BANC"
 *
 * S1: Put all character of t string into map with negative frequently, example {'A': -1, 'B': -1, 'C': -1}
 * S2: Check each character of s string, if it already in map, increase frequently --> freq >= 0
 * S3: If frequently equals 0, increase counter
 * S4: If counter equals size of map, check minLength and assign result
 * S5: Increase start index, decrease freq and counter if needed, until counter less than size of map
 * S6: Back to S2
 *
 * Time: O(m + n)
 * Space: O(n)
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int start = 0;
        int minLength = m + 1;
        int count = 0;
        String result = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }

        int size = freq.size();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
                if (freq.get(c) == 0) {
                    count++;
                }

                while (count == size) {
                    if (i - start + 1 < minLength) {
                        minLength = i - start + 1;
                        result = s.substring(start, i+1);
                    }
                    char cTmp = s.charAt(start);
                    if (freq.containsKey(cTmp)) {
                        freq.put(cTmp, freq.get(cTmp) - 1);
                        if (freq.get(cTmp) == -1) {
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        return result;
    }
}
