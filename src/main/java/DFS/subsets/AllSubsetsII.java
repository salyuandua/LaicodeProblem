package DFS.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set==null) return result;
        if (set.equals("")){
            result.add("");
            return result;
        }

        char[] setArray = set.toCharArray();
        Arrays.sort(setArray);
        helper(new String(setArray), 0, result, "", new HashSet<>());
        return result;
    }

    private void helper(String set, int layer, List<String> res, String curRes, Set<String> hashSet) {
        if(layer >= curRes.length()) {
            if(!hashSet.contains(curRes)) {
                res.add(curRes);
                hashSet.add(curRes);
                return;
            }
        }

        helper(set, layer + 1, res, curRes + set.charAt(layer), hashSet);
        helper(set, layer + 1, res, curRes, hashSet);
    }
}
