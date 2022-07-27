package string;

public class ReverseWordsInASentenceII1 {
    public String reverseWords(String input) {
        // Write your solution here
        if(input == null || input.length() == 0) return input;
        input = input.trim();
        input = removeSpaces(input);
        char[] inpurArray = input.toCharArray();
        reverseString(inpurArray, 0, input.length() - 1);
        int fast = 0;
        int begin = 0;
        while(fast < inpurArray.length) {
            if(inpurArray[fast] == ' ') {
                reverseString(inpurArray, begin, fast - 1);
                begin = fast + 1;
            }
            if(fast == inpurArray.length - 1) {
                reverseString(inpurArray, begin, fast);
            }
            fast++;
        }
        return new String(inpurArray);

      }

      private void reverseString(char[] input, int i, int j) {
        while(i < j) {
            char c = input[i];
            input[i] = input[j];
            input[j] = c;
            i++;
            j--;
        }
      }

      private String removeSpaces(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < input.length()) {
            char c = input.charAt(i);
            if(c == ' ') {
                sb.append(c);
                i++;
                while(i < input.length() && input.charAt(i) == ' ') {
                    i++;
                }
            }
            if(i >= input.length()) break;
            sb.append(input.charAt(i));
            i++;
        }
        return sb.toString();
      }

      public static void main(String[] args) {
        ReverseWordsInASentenceII1 rASentenceII1 = new ReverseWordsInASentenceII1();
        System.out.println(rASentenceII1.reverseWords("  I  love  Google  ")); 
      }
}
