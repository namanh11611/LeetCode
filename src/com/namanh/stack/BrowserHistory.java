package com.namanh.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/design-browser-history
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history
 * number of steps or move forward in the history number of steps.
 *
 * S1: Use two stack one for back history and one for forward history
 */
public class BrowserHistory {
    Stack<String> history = new Stack<>();
    Stack<String> forward = new Stack<>();

    public BrowserHistory(String homepage) {
        history.push(homepage);
    }

    public void visit(String url) {
        if (!forward.isEmpty()) forward.clear();
        history.push(url);
    }

    public String back(int steps) {
        while (steps-- > 0 && history.size() > 1) {
            forward.push(history.pop());
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps-- > 0 && !forward.isEmpty()) {
            history.push(forward.pop());
        }
        return history.peek();
    }
}
