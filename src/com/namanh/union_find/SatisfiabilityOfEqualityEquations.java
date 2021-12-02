package com.namanh.union_find;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations
 * You are given an array of strings equations that represent relationships between variables where each string
 * equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi". Return true if it is possible
 * to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
 *
 * S1: First, union find equation elements, use path compress
 * S2: Gather not equation string in ArrayList
 * S3: Check root of 2 elements in each not equation string, return false if same root
 * S4: Return true
 *
 * Time: O(n)
 * Space: O(n)
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        List<String> diff = new ArrayList<>();
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                diff.add(str);
            } else {
                int rootA = findRootChar(parent, str.charAt(0));
                int rootB = findRootChar(parent, str.charAt(3));
                parent[rootA] = rootB;
            }
        }

        for (String str : diff) {
            int rootA = findRootChar(parent, str.charAt(0));
            int rootB = findRootChar(parent, str.charAt(3));
            if (parent[rootA] == parent[rootB]) {
                return false;
            }
        }
        return true;
    }

    private int findRootChar(int[] parent, char c) {
        return findRoot(parent, c - 97);
    }

    private int findRoot(int[] parent, int c) {
        if (c != parent[c]) {
            parent[c] = findRoot(parent, parent[c]);
        }
        return parent[c];
    }
}
