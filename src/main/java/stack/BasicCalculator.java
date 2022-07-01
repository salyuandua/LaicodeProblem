package stack;

import java.util.Stack;

public class BasicCalculator {
    // public int calculate(String input) {
    //     // Write your solution here
    //     Stack<Character> stack = new Stack<>();
    //     for(int i = 0; i < input.length(); i++) {
    //         char c = input.charAt(i);
    //         if(c == ')') {
    //             int sum = 0;
    //             int prevNum = 0;
    //             while(!stack.empty() && stack.peek() != '(') {
    //                 char c1 = stack.pop();
    //                 if(Character.isDigit(c1)) {
    //                     sum += c1;
    //                     prevNum = c1 - '0';
    //                 }else if(c1 == '-') {
    //                     sum = sum - 2 * prevNum;
    //                 }
    //             }
    //             stack.pop();
    //             //stack.push(sum);
    //         }
    //     }
    //   }
}
