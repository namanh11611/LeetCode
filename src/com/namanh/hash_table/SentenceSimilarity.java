package com.namanh.hash_table;

import java.util.*;

/**
 * https://leetcode.com/problems/sentence-similarity
 * Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs
 * similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
 * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
 * The similarity relation is not transitive. (a = b & b = c -> a != c)
 *
 * S1: Create a map of word, key is word and value is list of similar word
 * S2: Check 2 sentence, if their length is different, return false
 * S3: Check each word, if they are different and not similar, return false
 * S4: Return true
 *
 * Time: O(n)
 * Space: O(n)
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length;
        if (sentence2.length != n) return false;

        Map<String, Set<String>> wordMap = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            wordMap.putIfAbsent(word1, new HashSet<>());
            wordMap.get(word1).add(word2);

            wordMap.putIfAbsent(word2, new HashSet<>());
            wordMap.get(word2).add(word1);
        }

        for (int i = 0; i < n; i++) {
            if (!sentence1[i].equals(sentence2[i])) {
                Set<String> list = wordMap.getOrDefault(sentence1[i], new HashSet<>());
                if (!list.contains(sentence2[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Join 2 word, separate by |, add into Set
     */
    public boolean areSentencesSimilar2(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length;
        if (sentence2.length != n) return false;

        Set<String> pairs = new HashSet<>();
        for (List<String> similarPair : similarPairs) {
            pairs.add(similarPair.get(0) + "|" + similarPair.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!sentence1[i].equals(sentence2[i])
                    && !pairs.contains(sentence1[i] + "|" + sentence2[i])
                    && !pairs.contains(sentence2[i] + "|" + sentence1[i])) {
                return false;
            }
        }
        return true;
    }
}
