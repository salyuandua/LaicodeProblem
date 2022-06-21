package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String source, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int count = map.size();
        while(right < source.length()) {
            char rightChar = source.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) count--;
            }
            right++;
            while(count == 0) {
                if(right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }
                char leftChar = source.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0) count++;
                }
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : source.substring(start, start + minLength);

    }
    
}
