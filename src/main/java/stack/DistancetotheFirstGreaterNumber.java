package stack;

import java.util.Arrays;
import java.util.Stack;

public class DistancetotheFirstGreaterNumber {
    public static int[] distanceToFirstGreater(int[] nums) {
        // Write your solution here
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i];
            while(!stack.isEmpty() && cur >= nums[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return result;
    }

    static class Entry {
        int idx;
        int value;

        public Entry(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distanceToFirstGreater(new int[]{5,6,7,3,2,4,8,1})));
    }

}
