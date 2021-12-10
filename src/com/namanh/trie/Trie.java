package com.namanh.trie;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in
 * a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class.
 */
public class Trie {
    class Node {
        char c;
        Node[] children = new Node[26];
        boolean isEnd;

        Node() {}

        Node(char c) {
            this.c = c;
        }
    }

    private Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            // Only add new node when it is null
            if (cur.children[c-97] == null) {
                cur.children[c-97] = new Node(c);
            }
            cur = cur.children[c-97];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = head;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c-97] == null) return false;
            cur = cur.children[c-97];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (cur.children[c-97] == null) return false;
            cur = cur.children[c-97];
        }
        return true;
    }
}
