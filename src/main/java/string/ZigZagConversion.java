package string;

public class ZigZagConversion {
    public String convert(String input, int nRows) {
        // Write your solution here
        if (input == null || input.equals("")) return input;
        char[] inputArray = input.toCharArray();
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int idx = 0;
        while (idx < inputArray.length) {
            for (int i = 0; i < nRows && idx < inputArray.length; i++) {
                sb[i].append(inputArray[idx++]);
            }
            for (int i = nRows - 2; i >= 1 && idx < inputArray.length; i--) {
                sb[i].append(inputArray[idx++]);
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
