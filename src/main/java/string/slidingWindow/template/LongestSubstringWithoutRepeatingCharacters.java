package string.slidingWindow.template;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if (input == null || input.length() == 0) return 0;
        int slow = 0;
        int fast = 0;
        int max = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (fast < input.length()) {
            char c = input.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                count++;
            }

            while (count > 0) {
                char slowChar = input.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);
                if (map.get(slowChar) == 1) {
                    count--;
                }
                slow++;
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}
