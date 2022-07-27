package bit;

public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        // Write your solution here
        int c = a ^ b;
        int count = 0;
        while(c != 0) {
            c = c &(c - 1);
            count++; 
        }
        return count;
    }
}
