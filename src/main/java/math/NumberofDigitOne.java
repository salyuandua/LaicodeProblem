package math;

public class NumberofDigitOne {
    public int countDigitOne(int n) {
        // Write your solution here
        if (n <= 0) return 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getOneCount(i);
        }
        return sum;
    }

    private static int getOneCount(int n) {
        int count = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem == 1) count++;
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getOneCount(1));
    }
}
