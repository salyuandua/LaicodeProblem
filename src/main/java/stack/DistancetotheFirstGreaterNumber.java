package stack;

import java.util.Arrays;
import java.util.Stack;

public class DistancetotheFirstGreaterNumber {
    public static int[] distanceToFirstGreater(int[] nums) {
        // Write your solution here
        int[] result = new int[nums.length];
        Stack<Entry> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!stack.isEmpty() && cur > stack.peek().value) {
                Entry entry = stack.pop();
                result[entry.idx] = i - entry.idx;
            }
            stack.push(new Entry(i, cur));
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
