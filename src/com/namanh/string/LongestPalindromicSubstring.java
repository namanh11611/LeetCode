package com.namanh.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstring {
    String mString;
    int length;
    int maxLength = 1;
    String result;

    public String longestPalindrome(String s) {
        mString = s;
        result = "" + s.charAt(0);
        length = s.length();
        int index = 0;
        while (index < length - 1) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                getPalindromic(index - 1, index + 2);
            }
            if (index < length - 2 && s.charAt(index) == s.charAt(index + 2)) {
                getPalindromic(index - 1, index + 3);
            }
            index++;
        }
        return result;
    }

    private void getPalindromic(int start, int end) {
        int curLength = end - start - 1;
        while (start >= 0 && end < length && mString.charAt(start) == mString.charAt(end)) {
            start--;
            end++;
            curLength += 2;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
            result = mString.substring(start + 1, end);
        }
    }
}
