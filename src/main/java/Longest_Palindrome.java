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
        String word = "babad";
        System.out.println("Longest Palindrome: "+ longestPalindrome(word));
    }

    public static String longestPalindrome(String s) {
        String palindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if(s.substring(i,j).contentEquals(new StringBuilder(s.substring(i,j)).reverse()))
                    return s.substring(i,j);//if no finds palindromic, returns the first letter
            }
        }
        return palindrome;
    }
}
