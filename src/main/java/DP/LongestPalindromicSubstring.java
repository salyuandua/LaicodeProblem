package DP;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String input) {
        // Write your solution here
        if (input == null || input.length() == 0 || input.length() == 1) return input;
        int n = input.length();
        boolean[][] m = new boolean[n][n];
        String result = "";
        for (int end = 0; end < n; end++) {
            for (int begin = 0; begin <= end; begin++) {
                if (input.charAt(begin) != input.charAt(end)) continue;
                if (end - begin + 1 < 3 || m[begin + 1][end - 1]) {
                    m[begin][end] = true;
                }
                if (m[begin][end] && end - begin + 1 > result.length()) {
                    result = input.substring(begin, end + 1);
                }
            }
        }
        return result;
    }

    public static String longestPalindrome1(String input) {
        if (input == null || input.length() == 0 || input.length() == 1) return input;
        int n = input.length();
        boolean[][] m = new boolean[n][n];
        int start = 0;
        int end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (input.charAt(i) != input.charAt(j)) continue;
                if (i == j || i + 1 == j || m[i + 1][j - 1]) {
                    m[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return input.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcbcbd"));
    }
}
