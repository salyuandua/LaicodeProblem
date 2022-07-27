package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringReplace {
   public static String replace(String input, String source, String target) {
       // Write your solution here
       char[] inputArray = input.toCharArray();
       Set<Integer> startIdx = new HashSet<>();
        for(int i = 0; i < inputArray.length; i++) {
            int j = i ;
            int k = 0;
            while(j < inputArray.length && k < source.length() && inputArray[j] == source.charAt(k)) {
                j++;
                k++;
            }
            if(k == source.length()) {
                startIdx.add(i);
            }
        }

        if(startIdx.isEmpty()) return input;
        StringBuilder sb = new StringBuilder();
        int i  = 0;
        while(i < input.length()) {
            if(startIdx.contains(i)) {
                sb.append(target);
                i+= source.length();
                continue;
            }
            sb.append(input.charAt(i));
            i++;
        }
        return sb.toString();
   }

   public static void main(String[] args) {
    System.out.println(replace("appledogapple", "apple", "cat"));
   }
}
