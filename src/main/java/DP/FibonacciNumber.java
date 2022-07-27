package DP;

public class FibonacciNumber {
    public int fibonacci(int K) {
        // Write your solution here
        int[] m = new int[K];
        m[0] = 0;
        m[1] = 1;
        for(int i = 2; i < K; i++) {
            m[i] = m[i-1] + m[i-2];
        }
        return m[K -1];
    }
}
