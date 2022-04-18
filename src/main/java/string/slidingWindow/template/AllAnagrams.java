package string.slidingWindow.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> result = new ArrayList<>();
        if (sh == null || sh.length() == 0 || sh.length() < lo.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : lo.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int counter = map.size();
        for (int right = 0; right < sh.length(); right++) {
            char rightChar = sh.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) counter--;
            }

            while (counter == 0) {
                if (right - left + 1 ==lo.length()) result.add(left);
                char leftChar = sh.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) counter++;
                }
                left++;
            }
        }
        return result;
    }
}
