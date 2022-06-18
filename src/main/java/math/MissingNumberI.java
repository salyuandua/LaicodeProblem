package math;

public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here
        int n = array.length + 1;
        double sum = (1 + n) * (n / 2.0);
        for (int a : array) {
            sum -= a;
        }
        return (int) sum;
    }


}
