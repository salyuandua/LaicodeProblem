package binaryTree;

import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
    public static boolean isValidSerialization(String preorder) {
        // Write your solution here
        if (preorder == null || preorder.equals("")) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        String[] seq = preorder.split(",");
        for (int i = 0; i < seq.length; i++) {
            String cur = seq[i];
            if (!cur.equals("#")) {
                stack.push(cur);
                continue;
            }

            while (cur.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");

    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
