package string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String input) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (input == null || input.length() <=1) return result;
        char[] inputArray = input.toCharArray();
        int slow = 0;
        int fast = 1;
        while (fast < inputArray.length) {
            if (inputArray[slow] == '+' && inputArray[fast] == '+') {
                inputArray[slow] = '-';
                inputArray[fast] = '-';
                result.add(new String(inputArray));
                inputArray[slow] = '+';
                inputArray[fast] = '+';
            }
            slow++;
            fast++;
        }
        return result;
    }
}
