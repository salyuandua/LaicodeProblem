package string;

public class FlipGameII {
    public boolean canWin(String input) {
        // Write your solution here
        if (input == null || input.length() ==0) return false;
        return helper(input.toCharArray());
    }

    private boolean helper(char[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == '+' && input[i+1] == '+') {
                input[i] = '-';
                input[i+1] = '-';
                boolean otherWin = helper(input);
                input[i] = '+';
                input[i+1] = '+';
                if (!otherWin) return true;
            }
        }
        return false;
    }
}
