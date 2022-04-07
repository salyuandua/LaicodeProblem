package string.dedupliate;

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if(input == null || input.equals("")) return input;
        int slow = 0;
        char[] inputArray = input.toCharArray();
        for (int fast = 1; fast < input.length(); fast++) {
            if (inputArray[fast] != inputArray[slow]) {
                inputArray[++slow] = inputArray[fast];
            }
        }
        return new String(inputArray, 0, slow + 1);
    }
}
