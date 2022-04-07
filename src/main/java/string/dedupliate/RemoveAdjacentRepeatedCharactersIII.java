package string.dedupliate;
//leaving no character for each group of such characters
public class RemoveAdjacentRepeatedCharactersIII {
    public String deDup(String input) {
        if (input == null || input.equals("")) return input;
        int slow = 0;
        int fast = 0;
        char[] inputArray = input.toCharArray();
        while (fast < inputArray.length) {
            int begin = fast;
            while (fast < inputArray.length && inputArray[begin] == inputArray[fast]) {
                fast++;
            }
            if (fast - begin == 1) {
                inputArray[slow++] = inputArray[begin];
            }
        }
        return new String(inputArray, 0, slow);
    }
}
