package DP;

public class LongestCommonSubstring {
    public String longestCommon(String source, String target) {
        int[][] m = new int[source.length() + 1][target.length() + 1];
        int begin = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    m[i][j] = m[i-1][j-1] + 1;
                    if (m[i][j] > max) {
                        max = m[i][j];
                        begin = i-1;
                    }
                }
            }
        }
        return new String(source.toCharArray(), begin, begin + max);
    }
}
