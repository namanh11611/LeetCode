package com.namanh.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the
 * answer in any order. A word matches the pattern if there exists a permutation of letters p so that after replacing
 * every letter x in the pattern with p(x), we get the desired word.
 * words[i].length == pattern.length
 *
 * S1: Create an array to store first index appearance of character in pattern
 *     Example: "abb" -> [0, 1, 1]
 * S2: Use map to check each word in words array
 * S3: Iterate character in word, if map already contains char, return false if map.get(c) not equals number[i]
 * S4: If map haven't contains char, return false if i not equals number[i]
 * S5: If all character match, add word into result
 *
 * Time: O(n * m) with n is length of words array, m is length of pattern/words[i]
 * Space: O(n * m)
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        int[] number = new int[n];
        Map<Character, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (mapIndex.containsKey(c)) {
                number[i] = mapIndex.get(c);
            } else {
                mapIndex.put(c, i);
                number[i] = i;
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (checkMatching(word, number)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean checkMatching(String word, int[] number) {
        Map<Character, Integer> mapIndex = new HashMap<>();
        int m = word.length();
        for (int i = 0; i < m; i++) {
            char c = word.charAt(i);
            if (mapIndex.containsKey(c)) {
                if (mapIndex.get(c) != number[i]) return false;
            } else {
                if (i != number[i]) return false;
                mapIndex.put(c, i);
            }
        }
        return true;
    }
}
