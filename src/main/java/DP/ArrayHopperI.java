package DP;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        boolean[] m = new boolean[array.length];
        m[m.length - 1] = true;
        int lastTrueIdx = m.length - 1;
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= lastTrueIdx) {
                m[i] = true;
                lastTrueIdx = i;
            }
        }
        return m[0];
    }
}
