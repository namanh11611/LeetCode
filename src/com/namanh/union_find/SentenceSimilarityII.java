package com.namanh.union_find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sentence-similarity-ii
 * Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs
 * similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
 * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
 * The similarity relation is transitive. (a = b & b = c -> a = c)
 *
 * S1: Use union find with path compression
 * S2: Merge similar words
 * S3: Check each word, return false if they don't have common root
 * S4: Return true
 *
 * Time: O(n + p) with p is number pairs
 * Space: O(p)
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length;
        if (sentence2.length != n) return false;

        Map<String, String> rootMap = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String root1 = findRoot(rootMap, pair.get(0));
            String root2 = findRoot(rootMap, pair.get(1));
            rootMap.put(root1, root2);
        }

        for (int i = 0; i < n; i++) {
            if (!sentence1[i].equals(sentence2[i])) {
                String root1 = findRoot(rootMap, sentence1[i]);
                String root2 = findRoot(rootMap, sentence2[i]);
                if (!root1.equals(root2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private String findRoot(Map<String, String> rootMap, String key) {
        rootMap.putIfAbsent(key, key);
        String root = rootMap.get(key);
        if (!root.equals(key)) {
            rootMap.put(key, findRoot(rootMap, root));
        }
        return rootMap.get(key);
    }
}
