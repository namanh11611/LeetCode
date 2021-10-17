package com.namanh.stack;

import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/valid-parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() &&
                    ((stack.peek() == '(' && c == ')')
                    || (stack.peek() == '{' && c == '}')
                    || (stack.peek() == '[' && c == ']'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
