package com.namanh.trie;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in
 * a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class.
 */
public class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            // Only add new node when it is null
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return false;
        }
        return true;
    }
}
