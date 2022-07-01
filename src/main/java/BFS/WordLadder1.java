package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue  =new LinkedList<>();
        int count = 1;
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            count++;
            String cur = queue.poll();
            List<String> nextWords = getNextWords(cur, dict);
            for(String nextWord : nextWords) {
                if(nextWord.equals(endWord)) return count;
                if(!visited.contains(nextWord)) {
                    queue.offer(nextWord);
                    queue.add(nextWord);
                }
            }
        }
        return 0;

    }

    private List<String> getNextWords(String word, Set<String> dict) {
        char[] wordArray = word.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < wordArray.length; i++) {
            char temp = wordArray[i];
            for(char c = 'a'; c <= 'z'; c++) {
                wordArray[i] = c;
                String newWord = new String(wordArray);
                if(dict.contains(newWord)) res.add(newWord);
                wordArray[i] = temp;
            }
        }
        return res;
    }
}
