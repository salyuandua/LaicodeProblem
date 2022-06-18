package array;

import java.util.Arrays;

public class RemoveElement {
    public int[] removeElement(int[] input, int value) {
        // Write your solution here
        if (input.length == 0) return input;
        int slow = 0;
        for (int fast = 0; fast < input.length; fast++) {
            if (input[fast] != value) {
                input[slow++] = input[fast];
            }
        }
        return Arrays.copyOf(input, slow);
    }

    public static void main(String[] args) {
        RemoveElement element = new RemoveElement();
        System.out.println(Arrays.toString(element.removeElement(new int[]{4,2,3,5}, 1)));
    }
}
