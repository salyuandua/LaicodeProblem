package DFS.permuation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsofSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        // Write your solution here

        List<String> subsets = new ArrayList<>();
        if (set == null) {
            return subsets;
        }
        subsets(set, 0, "", subsets);
        List<String> allperms = new ArrayList<>();
        for (int i = 0; i < subsets.size(); i++) {
            List<String> perms = new ArrayList<>();
            perm(subsets.get(i).toCharArray(), 0, perms);
            allperms.addAll(perms);
        }
        allperms.addAll(subsets);
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(allperms);
        List<String> result = new ArrayList<>();
        result.addAll(hashSet);
        return result;
    }

    private void subsets(String set, int layer, String ele, List<String> res) {
        if (layer == set.length()) {
            res.add(ele);
            return;
        }
        subsets(set, layer + 1, ele + set.charAt(layer), res);
        subsets(set, layer + 1, ele , res);
    }

    private void perm(char[] input, int layer, List<String> res) {
        if (layer > input.length - 1) {
            res.add(new String(input));
            return;
        }
        for (int i = layer; i < input.length; i++) {
            swap(input, layer, i);
            perm(input, layer + 1, res);
            swap(input, layer, i);
        }
    }

    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
