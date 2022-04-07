package DFS.permuation;

public class FormARingWithWords {
    public boolean formRing(String[] input) {
        // Write your solution here
        boolean[] result = new boolean[1];
        helper(input, 0, result);
        return result[0];
    }

    private void helper(String[] input, int layer, boolean[] result) {
        if (layer == input.length) {
            if (check(input)) {
                result[0] = true;
            }
            return ;
        }
        for (int i = layer; i < input.length; i++) {
            swap(input, layer, i);
            helper(input, layer + 1, result);
            swap(input, layer, i);
        }
    }

    private void swap(String[] input, int i, int j) {
        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private boolean check(String[] input) {
        String firstStr = input[0];
        String lastStr = input[input.length-1];
        if (firstStr.charAt(0) != lastStr.charAt(lastStr.length() -  1)) {
            return false;
        }
        for (int i = 0; i < input.length-1; i++) {
            String cur = input[i];
            String next = input[i+1];
            if(cur.charAt(cur.length() -  1) != next.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
