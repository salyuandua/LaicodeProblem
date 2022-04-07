package BFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.remove();
                count++;
                List<String> nextWords = nextWords(curWord, dict);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) {
                        return count;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(curWord);
                    }
                }
            }


        }
        return count;
    }

    private List<String> nextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                char[] wordArray = word.toCharArray();
                wordArray[i] = j;
                String nextWord = new String(wordArray);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
