package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        if(input == null || input.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < input.length()) {
            char rightChar = input.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            right++;
            while(map.size() > k) {
                char leftChar = input.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;

    }
    
}
