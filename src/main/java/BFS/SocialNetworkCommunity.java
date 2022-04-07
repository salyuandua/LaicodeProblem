package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SocialNetworkCommunity {
    public int findCommunityNum(int[][] M) {
        // Write your solution here
        boolean[][] visited = new boolean[M.length][M[0].length];
        Queue<Entry> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    count++;
                    queue.add(new Entry(i, j));
                    while (!queue.isEmpty()) {
                        Entry cur = queue.remove();
                        visited[cur.x][cur.y] = true;
                        //top
                        if (cur.x - 1 >= 0 && M[cur.x - 1][cur.y] == 1 && !visited[cur.x - 1][cur.y]) {
                            queue.add(new Entry(cur.x - 1, cur.y));
                        }
                        if (cur.x + 1 < M.length && M[cur.x + 1][cur.y] == 1 && !visited[cur.x + 1][cur.y]) {
                            queue.add(new Entry(cur.x + 1, cur.y));
                        }
                        if (cur.y -1 >= 0 && M[cur.x][cur.y - 1] == 1 && !visited[cur.x][cur.y - 1]) {
                            queue.add(new Entry(cur.x, cur.y - 1));
                        }
                        if (cur.y + 1 < M[0].length && M[cur.x][cur.y + 1] == 1 && !visited[cur.x][cur.y + 1]) {
                            queue.add(new Entry(cur.x, cur.y + 1));
                        }

                    }
                }
            }

        }
        return count;
    }

    static class Entry {
        int x;
        int y;
        public Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        SocialNetworkCommunity community = new SocialNetworkCommunity();
        System.out.println(community.findCommunityNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
    }
}
