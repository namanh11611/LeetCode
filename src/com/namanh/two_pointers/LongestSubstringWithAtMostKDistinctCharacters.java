package com.namanh.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct
 * characters.
 *
 * S1: Use Map to store frequently of character
 * S2: Put character into map, or increase frequently if it already exists
 * S3: If map size over k, remove element from start index
 * S4: Result is current index minus start index
 *
 * Time: O(n)
 * Space: O(n)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int start = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.size() > k) {
                char cTmp = s.charAt(start);
                int fTmp = freq.get(cTmp);
                if (fTmp == 1) {
                    freq.remove(cTmp);
                } else {
                    freq.put(cTmp, fTmp - 1);
                }
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
