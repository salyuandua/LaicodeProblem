package DP;

public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return 1;
        int[] m = new int[array.length];
        m[0] = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            int localMax = 0;
            for (int j = i - 1; j >=0; j--) {
                if (array[i] > array[j]) {
                    localMax = Math.max(localMax, m[j]);
                }
            }
            m[i] = localMax + 1;
            max = Math.max(max, m[i]);
        }
        return max;
    }


}
