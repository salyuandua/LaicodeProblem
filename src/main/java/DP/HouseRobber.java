package DP;

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[] num) {
        if (num.length==0) return 0;
        if (num.length==1) return num[0];
        int[] m = new int[num.length];
        m[0] = num[0];
        m[1] = Math.max(num[1], m[0]);
        for (int i = 2; i < num.length; i++) {
            m[i] = Math.max(num[i] + m[i-2], m[i-1]);
        }
        return Math.max(m[m.length - 1], m[m.length - 2]);
    }

    public static int rob1(int[] num) {
        if (num.length==0) return 0;
        if (num.length==1) return num[0];
        int[] m = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            m[i] = Math.max((i > 1 ? m[i - 2] : 0) + num[i],
                    (i > 0 ? m[i - 1] : 0));
        }
        System.out.println(Arrays.toString(m));
        return Math.max(m[m.length - 1], m[m.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{11,6,5,4,3,10,5}));
        System.out.println(rob1(new int[]{11,6,5,4,3,10,5}));
    }
}
