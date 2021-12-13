package com.namanh.trie;

/**
 * https://leetcode.com/problems/implement-magic-dictionary
 * Design a data structure that is initialized with a list of different words. Provided a string, you should determine
 * if you can change exactly one character in this string to match any word in the data structure.
 */
public class MagicDictionary {
    private Node head;

    public MagicDictionary() {
        head = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String dic : dictionary) {
            Node cur = head;
            for (char c : dic.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(head, searchWord, 0, 1);
    }

    private boolean dfs(Node cur, String word, int index, int modifyCount) {
        if (cur == null || index == word.length() || modifyCount < 0) return false;
        boolean result = false;
        Node[] children = cur.children;
        int c = word.charAt(index);
        for (int i = 0; i < 26; i++) {
            int delta = 'a' + i == c ? 0 : 1;
            if (children[i] == null) continue;
            if (children[i].isEnd && index == word.length() - 1
                    && modifyCount == delta) return true;
            result |= dfs(children[i], word, index + 1, modifyCount - delta);
        }
        return result;
    }

    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }
}
