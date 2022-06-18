package DP;

public class LargestSubArraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int[] m = new int[array.length];
        m[0] = array[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (m[i - 1] < 0) {
                m[i] = array[i];
            }else {
                m[i] = m[i - 1] + array[i];
            }
            max = Math.max(max, m[i]);
        }
        return max;
    }
}
