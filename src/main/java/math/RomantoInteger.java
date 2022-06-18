package math;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put(null, 0);
        int result =  0;
        for (int i =0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i > 0 && map.get(c) > map.get(input.charAt(i - 1))) {
                result += (map.get(c) - map.get(input.charAt(i - 1)) - map.get(input.charAt(i - 1)));
            }else {
                result += map.get(c);
            }
        }
        return result;
    }


}
