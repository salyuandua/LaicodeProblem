package string.slidingWindow.template;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        // Write your solution here
        if (input == null || input.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int counter = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int fast = 0; fast < input.length(); fast++) {
            char fastChar = input.charAt(fast);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);
            if (map.get(fastChar) == 1) counter++;

            while (counter > k) {
                char slowChar = input.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);
                if (map.get(slowChar) == 0) counter--;
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}
