package DP;

public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        // Write your solution here
        int[][] m = new int[source.length() + 1][target.length() + 1];
        int max = 0;
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    m[i][j] = m[i-1][j-1] + 1;
                }else {
                    m[i][j] = Math.max(m[i][j-1], m[i-1][j]);
                }
                max = Math.max(max, m[i][j]);
            }
        }
        return max;
    }

    public int longest1(String s, String t) {
        int[][] match = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    match[i][j] = match[i - 1][j - 1] + 1;
                } else {
                    match[i][j] = Math.max(match[i - 1][j], match[i][j - 1]);
                }
            }
        }
        return match[s.length()][t.length()];
    }
}
