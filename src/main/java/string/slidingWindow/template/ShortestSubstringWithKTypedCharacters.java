package string.slidingWindow.template;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringWithKTypedCharacters {
    public String shortest(String input, int k) {
        // Write your solution here
        if (input == null || input.length() == 0) return input;
        Map<Character, Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int slow = 0;
        int begin = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            char fastChar = input.charAt(fast);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);
            while (map.size() > k) {
                char slowChar = input.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);
                if (map.get(slowChar) == 0) map.remove(slowChar);
                slow++;
            }
            if (fast - slow + 1 < minLength) {
                minLength = fast - slow + 1;
                begin = slow;
            }

        }
        return input.substring(begin, begin + minLength);
    }
}
