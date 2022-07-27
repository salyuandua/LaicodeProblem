package DFS;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandsII {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numIslands(int m, int n, int[][] positions) {
        // Write your solution here
        boolean[][] islands = new boolean[m][n];
        UF uf = new UF(m * n);
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] position : positions) {
            if(islands[position[0]][position[1]]) {
                res.add(count);
                continue;
            }
            islands[position[0]][position[1]] = true;
            count++;

            for(int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n || !islands[x][y]) continue;
                int cp1 = uf.find(position[0] * n + position[1]); 
                int cp2 = uf.find(x * n + y); 
                if(cp1 != cp2) {
                    uf.union(cp1, cp2);
                    count--;
                }
            }
            res.add(count);

        }
        
        return res;
    }


    private static class UF {
        int[] parents;
        public UF(int N) {
            parents = new int[N];
            for(int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            while(x != parents[x]) x = parents[x];
            return x;
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParnet = find(y);
            if(xParent == yParnet) return;
            parents[xParent] = yParnet;
        }

    }
}
