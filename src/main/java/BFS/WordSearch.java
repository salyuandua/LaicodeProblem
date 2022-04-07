package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {
    public boolean isWord(char[][] board, String word) {
        // Write your solution here

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Queue<Entry> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    queue.add(new Entry(i, j));
                    visited[i][j] = true;
                    int pointer = 1;
                    while (!queue.isEmpty()) {
                        Entry cur = queue.remove();
                        char c = word.charAt(pointer);
                        if (cur.i - 1 >= 0 && board[cur.i - 1][cur.j] == c && !visited[cur.i - 1][cur.j]) {
                            queue.add(new Entry(cur.i - 1, cur.j));
                            visited[cur.i - 1][cur.j] = true;
                            pointer++;
                        }
                        if (cur.i + 1 < board.length && board[cur.i + 1][cur.j] == c && !visited[cur.i + 1][cur.j]) {
                            queue.add(new Entry(cur.i + 1, j));
                            visited[cur.i + 1][cur.j] = true;
                            pointer++;
                        }
                        if (cur.j - 1 >= 0 && board[cur.i][cur.j - 1] == c && !visited[cur.i][cur.j - 1]) {
                            queue.add(new Entry(cur.i, cur.j - 1));
                            visited[cur.i][cur.j - 1] = true;
                            pointer++;
                        }
                        if (cur.j + 1 < board[0].length && board[cur.i][cur.j + 1] == c && !visited[cur.i][cur.j + 1]) {
                            queue.add(new Entry(cur.i, cur.j + 1));
                            visited[cur.i][cur.j + 1] = true;
                            pointer++;
                        }
                        if (pointer == word.length()) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    static class Entry {
        public int i;
        public int j;
        public Entry(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.isWord(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}
