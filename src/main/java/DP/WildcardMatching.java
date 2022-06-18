package DP;

public class WildcardMatching {
    public boolean match(String input, String pattern) {
        boolean[][] m = new boolean[input.length() + 1][pattern.length() + 1];
        m[0][0] = true;
        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*' && m[0][i-1]) {
                m[0][i] = true;
            }
        }
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                char c = pattern.charAt(j - 1);
                if (c == '*') {
                    m[i][j] = m[i-1][j] || m[i][j-1];
                }else if(c == '?') {
                    m[i][j] = m[i-1][j-1];
                }else if (input.charAt(i-1) == c) {
                    m[i][j] = m[i-1][j-1];
                }
            }
        }
        return m[input.length()][pattern.length()];
    }
}
