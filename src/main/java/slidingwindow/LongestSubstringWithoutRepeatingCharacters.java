package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if(input == null || input.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int max  =0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < input.length()) {
            char cur = input.charAt(right);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            right++;
            while(map.get(cur) > 1) {
                char leftChar = input.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
    
}
