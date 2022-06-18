package stack;

import java.util.Stack;

public class NextGreaterNumberII {

    public int[] nextGreaterElement(int[] nums) {
        // Write your solution here
        if (nums == null || nums.length == 0) return nums;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = nums.length * 2 - 1; i >=0; i--) {
            int cur = nums[i % nums.length];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i % nums.length] = -1;
            }else {
                result[i % nums.length] = stack.peek();
            }
            stack.push(cur);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(1 % 3);
    }
}
