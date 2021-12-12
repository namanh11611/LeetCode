package com.namanh.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/map-sum-pairs
 * Design a map that allows you to do the following:
 * - Maps a string key to a given value.
 * - Returns the sum of the values that have a key with a prefix equal to a given string.
 */
public class MapSum {
    class Node {
        int val;
        Node[] children = new Node[26];

        Node() {}

        Node(int val) {
            this.val = val;
        }

        void addVal(int val) {
            this.val += val;
        }
    }

    Node head;
    Map<String, Integer> map;

    public MapSum() {
        head = new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oldVal = map.getOrDefault(key, 0);
        map.put(key, val);
        val -= oldVal;
        Node cur = head;
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(0);
            }
            cur = cur.children[c - 'a'];
            cur.addVal(val);
        }
    }

    public int sum(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) return 0;
        }
        return cur.val;
    }
}
