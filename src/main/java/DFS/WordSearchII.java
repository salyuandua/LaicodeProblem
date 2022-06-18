package DFS;

import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        // Write your solution here
        return null;

    }

    private TireNode buildTire(String[] words) {
        TireNode root = new TireNode('*');
        TireNode cur = root;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TireNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    static class TireNode {
        TireNode[] children;
        char value;
        String word;
        public TireNode(char c) {
            this.value = c;
            children = new TireNode[26];
        }
    }
}
