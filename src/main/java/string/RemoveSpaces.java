package string;

public class RemoveSpaces {
    public static String removeSpaces(String input) {
        if (input == null) return null;
        char[] inputCharArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (inputCharArray[fast] == ' ') {
            slow++;
            fast++;
        }
        int end = inputCharArray.length - 1;
        while (inputCharArray[end] == ' ') {
            end--;
        }
        if (fast == end) return String.valueOf(inputCharArray[fast]);
        int begin = slow;
        while (fast <= end) {
            if (inputCharArray[fast] != ' ' || inputCharArray[fast - 1] != ' ') {
                inputCharArray[slow++] = inputCharArray[fast++];
                continue;
            }
            fast++;
        }
        return new String(inputCharArray, begin, slow - begin);
    }

    public static void main(String[] args) {
        System.out.println(removeSpaces(" I  LOVE YOU"));
    }
}
