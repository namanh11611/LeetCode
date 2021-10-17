package com.namanh.stack;

import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation
 * Question: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * S1: Use stack to save number
 * S2: If token is number, push it into stack
 * S3: If token is operator, pop 2 numbers and calculate, push result into stack
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result;
        for (String token : tokens) {
            if (token.equals("+")) {
                result = stack.pop() + stack.pop();
            } else if (token.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                result = first - second;
            } else if (token.equals("*")) {
                result = stack.pop() * stack.pop();
            } else if (token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                result = first / second;
            } else {
                stack.push(Integer.parseInt(token));
                continue;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}
