package bit;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        if(number == 0) return false;
        return (number & (number - 1)) == 0;
    }
}
