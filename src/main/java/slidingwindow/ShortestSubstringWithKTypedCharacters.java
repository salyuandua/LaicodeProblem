package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringWithKTypedCharacters {
    public String shortest(String input, int k) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int minLenth = Integer.MAX_VALUE;
        int start = 0;
        while(right < input.length()) {
            char rightChar = input.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            right++;
            while(map.size() == k) {
                if(minLenth < right - left) {
                    minLenth = right - left;
                    start = left;
                }
                char leftChar = input.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }
        }
        return minLenth == Integer.MAX_VALUE ? "" : input.substring(start, start + minLenth);
    }
}
