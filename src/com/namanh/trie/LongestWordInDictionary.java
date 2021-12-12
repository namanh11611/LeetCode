package com.namanh.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary
 * Given an array of strings words representing an English Dictionary, return the longest word in words that can be
 * built one character at a time by other words in words.
 *
 * S1: Sort words array
 * S2: Use Set to save valid string
 * S3: Iterate word array, check if substring from 0 to length - 1 is valid word, add current word into Set
 * S4: Update result if current word have greater length
 */
public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        set.add(result);
        for (String word : words) {
            int length = word.length();
            if (set.contains(word.substring(0, length - 1))) {
                set.add(word);
                if (length > result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    public String longestWord2(String[] words) {
        Trie trie = new Trie();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            trie.insert(words[i], i + 1);
        }
        return trie.findLongestWord(words);
    }

    class Node {
        Node[] children = new Node[26];
        int index;
        int length;
    }

    class Trie {
        private Node head;
        private int maxL = 0;
        private int index = 0;

        public Trie() {
            head = new Node();
        }

        public void insert(String word, int index) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.index = index;
            cur.length = word.length();
        }

        public String findLongestWord(String[] words) {
            dfs(head);
            return index == 0 ? "" : words[index - 1];
        }

        private void dfs(Node node) {
            for (Node child : node.children) {
                if (child != null && child.index > 0) {
                    if (child.length > maxL) {
                        index = child.index;
                        maxL = child.length;
                    }
                    dfs(child);
                }
            }
        }
    }
}
