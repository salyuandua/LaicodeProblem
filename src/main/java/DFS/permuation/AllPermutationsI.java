package DFS.permuation;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (input == null) {
            return res;
        }
        helper(input.toCharArray(), 0, res);
        return res;
    }

    private void helper(char[] input, int layer, List<String> res) {
        if (layer > input.length - 1) {
            res.add(new String(input));
            return;
        }
        for (int i = layer; i < input.length; i++) {
            swap(input, layer, i);
            helper(input, layer + 1, res);
            swap(input, layer, i);
        }
    }

    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
