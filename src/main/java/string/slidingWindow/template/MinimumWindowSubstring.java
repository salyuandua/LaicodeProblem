package string.slidingWindow.template;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String source, String target) {
        // Write your solution here
        if (source == null || source.length() == 0 || source.length() < target.length()) return source;
        if (target.length() == 0) return target;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int counter = map.size();
        int minLength = Integer.MAX_VALUE;
        int begin = 0;
        for (int right = 0; right < source.length(); right++) {
            char rightChar = source.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) counter--;
            }

            while (counter == 0) {
                if (right - left + 1 < minLength){
                    minLength = right - left + 1;
                    begin = left;
                }
                char leftChar = source.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) counter++;
                }
                left++;
            }
        }
        return source.substring(begin, begin + minLength);

    }
}
