package string.decompress;
//“abbcccdeee” → “ab2c3de3”
public class CompressString {
    public static String compress(String input) {
        if (input == null ||input.equals("")) return input;
        char[] inputArray = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int slow = 0;
        int fast = 1;
        while (fast < inputArray.length) {
            if (inputArray[slow] != inputArray[fast]) {
                result.append(inputArray[slow]);
                //result.append("1");
                slow++;
                fast++;
                continue;
            }
            while (fast < inputArray.length && inputArray[fast] == inputArray[slow]) {
                fast++;
            }
            int dist = fast - slow ;
            result.append(inputArray[slow] + "" + dist);
            slow = fast;
            fast++;
        }
        if (slow <= inputArray.length-1) {
            result.append(inputArray[slow]);
            result.append("1");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("abbcccde"));
    }
}
