package DP;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return longestIncreasingSubsequence(heights);

    }

    private int longestIncreasingSubsequence(int[] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return 1;
        int[] m = new int[array.length];
        Arrays.fill(m, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    m[i] = Math.max(m[i], m[j] + 1);
                }
            }
            max = Math.max(max, m[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes dollEnvelopes = new RussianDollEnvelopes();
        System.out.println(dollEnvelopes.maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}}));
    }
}
