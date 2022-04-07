package string.dedupliate;
// leaving only two characters for each group of such characters.
public class RemoveAdjacentRepeatedCharactersII {
    public String deDup(String input) {
        if (input == null || input.length() < 3) return input;
        char[] inputArray = input.toCharArray();
        int slow = 2;
        for (int fast = 2; fast < inputArray.length; fast++) {
            if (inputArray[slow - 2] != inputArray[fast]) {
                inputArray[slow++] = inputArray[fast];
            }
        }
        return new String(inputArray, 0, slow);
    }
}
