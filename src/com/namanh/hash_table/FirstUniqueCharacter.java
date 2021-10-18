package com.namanh.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string
 * Question: Find the first non-repeating character in it and return its index.
 * S1: Save position of character into Map, if duplicate, set -1
 * S2: Get first character have value different -1
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int length = s.length();
        if (length == 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (int i = 0; i < length; i++) {
            int value = map.get(s.charAt(i));
            if (value != -1) {
                return value;
            }
        }
        return -1;
    }
}
