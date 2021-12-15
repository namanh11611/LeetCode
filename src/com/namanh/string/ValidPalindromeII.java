package com.namanh.string;

/**
 * https://leetcode.com/problems/valid-palindrome-ii
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * S1: Use 2 pointer, move from start and end of string to compare character at start and end index
 * S2: In first iterate, if they different, check 2 cases [left + 1, right] or [left, right - 1]
 * S3: Return true if at least 1 case is valid palindrome
 *
 * Time: O(n)
 * Space: O(1)
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return validSubString(s, 0, s.length() - 1, 1);
    }

    public boolean validSubString(String s, int left, int right, int count) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (count > 0) {
                    return validSubString(s, left + 1, right, 0)
                            || validSubString(s, left, right - 1, 0);
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
