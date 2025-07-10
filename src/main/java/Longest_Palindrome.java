public class Longest_Palindrome {
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
Example 2:
    Input: s = "cbbd"
    Output: "bb"

Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters.
 */

    public static void main(String[] args) {
    }

    public String longestPalindrome(String s) {
        StringBuilder palindrome = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if(s.substring(i,j).equals(new StringBuilder(s.substring(i,j)).reverse().toString()))
                    return s.substring(i,j);
            }
        }

        return palindrome.toString();
    }
}
