package string;

import java.util.ArrayList;
import java.util.List;

public class SolveLinearEquation {
    public String solveEquation(String equation) {
        // Write your solution here
        String[] equations = equation.split("=");
        List<String> constants = new ArrayList<>();
        List<String> xEquations = new ArrayList<>();
        int factor = 0;
        for(String x : xEquations) {
            char op = x.charAt(0);
            int num = x.length() == 1 ? 1 : Integer.parseInt(x.substring(1, x.length() - 1));
            if(op == '+') {
                factor += num;
            }else{
                factor += -num;
            }
        }
        int constant = 0;
        for(String x : constants) {
            char op = x.charAt(0);
            int num = Integer.parseInt(x.substring(1, x.length()));
            if(op == '+') {
                constant += num;
            }else{
                constant += -num;
            }
        }

        return "";
    }

    private void helper(String equation, List<String> constants, List<String> xEquations) {
        int slow= 0;
        char op = '+';
        for(int fast = 0; fast < equation.length(); fast++) {
            char c = equation.charAt(fast);
            if(c == '+' || c == '-') {
                String part = String.valueOf(op) + equation.substring(slow, fast);
                if(part.contains("x")) {
                    xEquations.add(part);
                }else{
                    constants.add(part);
                }
                op = c;
            }
        }
    }
}
