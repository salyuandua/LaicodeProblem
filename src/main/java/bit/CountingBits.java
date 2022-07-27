package bit;

public class CountingBits {
    public int[] countBits(int num) {
        // Write your solution here
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
      }

    private int count(int n) {
        int res = 0;
        while(n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
