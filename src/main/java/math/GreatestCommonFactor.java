package math;

public class GreatestCommonFactor {
    public int gcf(int a, int b) {
        // Write your solution here
        int small = Math.min(a, b);
        int max = Math.max(a, b);
        return helper(max, small);
    }

    private int helper(int a, int b) {
        if (b == 0) {
            return a;
        }
        return helper(b, a % b);
    }
}
