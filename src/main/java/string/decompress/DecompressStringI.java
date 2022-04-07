package string.decompress;

public class DecompressStringI {
    public static String decompress(String input) {
        if (input == null || input.length() == 0 || input.length() == 1) return input;
        int slow = 0;
        int fast = 1;
        StringBuilder result = new StringBuilder();
        while (fast < input.length()) {
            if (!Character.isDigit(input.charAt(fast))) {
                result.append(input.charAt(slow));
                slow++;
                fast++;
                continue;
            }
            int count = Character.getNumericValue(input.charAt(fast));
            for (int i = 0; i < count; i++) {
                result.append(input.charAt(slow));
            }
            slow = fast + 1;
            fast += 2;
        }
        if (slow <= input.length() - 1) {
            result.append(input.charAt(slow));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decompress("acbc"));
    }

}
