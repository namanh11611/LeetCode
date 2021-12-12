package com.namanh.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/submissions
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three
 * product names from products after each character of searchWord is typed. Suggested products should have common prefix
 * with the searchWord. Return list of lists of the suggested products after each character of searchWord is typed.
 */
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String p : products) {
            trie.insert(p);
        }

        return trie.searchString(searchWord);
    }

    class Node {
        Node[] children = new Node[26];
        String word;
    }

    class Trie {
        private Node head;

        public Trie() {
            head = new Node();
        }

        public void insert(String word) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        public List<List<String>> searchString(String searchWord) {
            List<List<String>> result = new ArrayList<>();
            Node cur = head;
            for (char c : searchWord.toCharArray()) {
                if (cur != null) {
                    cur = cur.children[c - 'a'];
                }
                List<String> match = new ArrayList<>();
                search(cur, match);
                result.add(match);
            }
            return result;
        }

        private void search(Node node, List<String> match) {
            if (node == null || match.size() >= 3) return;
            if (node.word != null) {
                match.add(node.word);
            }
            for (Node child : node.children) {
                search(child, match);
            }
        }
    }
}
