package com.namanh.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    /**
     * S1: Use Two Pointer (See FruitIntoBaskets)
     * S2: Iterate string, compare current char with first, second
     * S3: Update lastCharString and curLength
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char first = '0', second = '0';
        int lastCharString = 0;
        int curLength = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == second) {
                lastCharString++;
                curLength++;
            } else {
                if (c == first) {
                    curLength++;
                } else {
                    curLength = lastCharString + 1;
                }
                lastCharString = 1;
                first = second;
                second = c;
            }
            max = Math.max(max, curLength);
        }
        return max;
    }

    /**
     * S1: Use Map to store frequently of character
     * S2: Put character into map, or increase frequently if it already exists
     * S3: If map size over 2, remove element from start index
     * S4: Result is current index minus start index
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int start = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.size() > 2) {
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
