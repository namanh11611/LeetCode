package com.namanh.string;

/**
 * https://leetcode.com/problems/valid-palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
 * numbers. Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * S1: Use 2 pointer, move from start and end of string to find valid character
 * S2: Compare character at start and end index, return false if they different
 * S3: Return true
 *
 * Time: O(n)
 * Space: O(1)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (right > left && !isValid(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
