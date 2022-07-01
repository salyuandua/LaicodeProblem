package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        Set<String> visited = new HashSet<>();
        List<String> curRes = new ArrayList<>();
        curRes.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        helper(beginWord, endWord, visited, dict, curRes, res);
        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1.size(), o2.size());
            }
            
        });
        return res;
    }

    private void helper(String beginWord, String endWord, Set<String> visited, Set<String> dict,
     List<String> curRes, List<List<String>> res) {
        System.out.println(beginWord);
        List<String> nextWords = getNextWords(beginWord, dict);
        for(String nextWord : nextWords) {
            if(nextWord.equals(endWord)) {
                curRes.add(nextWord);
                res.add(new ArrayList<>(curRes));
                curRes.remove(nextWord);
                return;
            }
            if(!visited.contains(nextWord)) {
                visited.add(nextWord);
                curRes.add(nextWord);
                helper(nextWord, endWord, visited, dict, curRes, res);
                curRes.remove(nextWord);
            }
        }

    }

    private List<String> getNextWords(String word, Set<String> dict) {
        char[] wordArray = word.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < wordArray.length; i++) {
            char temp = wordArray[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == temp) continue;
                wordArray[i] = c;
                String newWord = new String(wordArray);
                if(dict.contains(newWord)) res.add(newWord);
                wordArray[i] = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        System.out.println(wordLadderII.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
