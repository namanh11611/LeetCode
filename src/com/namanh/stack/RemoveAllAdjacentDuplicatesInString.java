package com.namanh.stack;

import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
 * Question: Return the final string after all such duplicate removals have been made.
 * S1: Use stack remove all two adjacent and equal letters
 * S2: Print result
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
