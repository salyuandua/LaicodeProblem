package slidingwindow;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // write your code here
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()) {
            map[s.charAt(right) - 'A']++;
            right++;
            while(right - left - findMax(map) > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    private int findMax(int[] map) {
       return Arrays.stream(map).max().getAsInt();
    }
}

