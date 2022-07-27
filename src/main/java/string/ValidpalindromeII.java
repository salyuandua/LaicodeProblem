package string;

public class ValidpalindromeII {
    public boolean validPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;
        while(left < right) {
            if(input.charAt(left) != input.charAt(right)) {
                return helper(input, left, right - 1) || helper(input, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean helper(String input, int left, int right) {
        for(int i = left, j = right; left < right; i++, j--) {
            if(input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
