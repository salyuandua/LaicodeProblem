package DFS;

public class CountandSay {
    public String countAndSay(int n) {
        // Write your solution here
        if(n == 0) return "";
        return helper("1", 0, n);
    }

    private String helper(String input, int layer, int n) {
        if(layer >= n) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            int size = 1;
            char c = input.charAt(i);
            while(i + 1 < input.length() && c == input.charAt(i + 1)) {
                i++;
                size++;
            }
            sb.append(String.valueOf(size) + String.valueOf(c));
        }
        return helper(sb.toString(), layer + 1, n);
    }

    public static void main(String[] args) {
        CountandSay countandSay = new CountandSay();
        System.out.println(countandSay.countAndSay(3));
    }
    
}
