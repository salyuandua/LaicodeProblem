package math;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(8, 8);
        map.put(6, 9);
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            Integer leftNum = Character.getNumericValue(num.charAt(left));
            Integer rightNum = Character.getNumericValue(num.charAt(right));
            if (!rightNum.equals(map.get(leftNum)) && !leftNum.equals(map.get(rightNum))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("6"));
    }
}
