package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        // Write your solution here
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                String first = input.substring(0, i);
                String second = input.substring(i + 1);
                List<Integer> firstAns = diffWaysToCompute(first);
                List<Integer> secondAns = diffWaysToCompute(second);
                for(int num1 : firstAns) {
                    for(int num2 : secondAns) {
                        int localAns = 0;
                        if(c == '+') {
                            localAns = num1 + num2;
                        }else if(c == '-') {
                            localAns = num1 - num2;
                        }else if(c == '*') {
                            localAns = num1 * num2;
                        }
                        ans.add(localAns);
                    }
                }
            }
        }
        if(ans.isEmpty()) {
            ans.add(Integer.parseInt(input));
        }
        Collections.sort(ans);
        return ans;
      }
}
