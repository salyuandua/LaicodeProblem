package array;

public class Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        int fast = 0;
        int slow = 0;
        while (fast < array.length) {
            if (array[fast] == 0) {
                fast++;
                continue;
            }
            array[slow++] = array[fast++];
        }
        while (slow < array.length) {
            array[slow++] = 0;
        }
        return array;
    }
}
