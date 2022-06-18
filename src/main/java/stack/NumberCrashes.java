package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NumberCrashes {
    public static int[] numberCrash(int[] nums) {
        // Write your solution here
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (num > 0) {
                stack.push(num);
                continue;
            }
            boolean numLose = false;
            while (!stack.isEmpty() && stack.peek() > 0 && !numLose) {
                int prev = stack.peek();
                if (Math.abs(num) > prev) {
                    stack.pop();
                }else if (Math.abs(num) < prev) {
                    numLose = true;
                }else {
                    stack.pop();
                    numLose = true;
                }
            }
            if (!numLose) stack.push(num);
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberCrash(new int[]{-1,1,2,-3})));
    }
}
