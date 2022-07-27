package BFS;

public class SocialNetworkCommunity1 {
    public int findCommunityNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count;
    }

    private static class UF {
        int[] parents;
        int count;
        public UF(int N) {
            parents = new int[N];
            for(int i = 0; i < N; i++) {
                parents[i] = i;
            }
            count = N;
        }

        public int find(int x) {
            while(x != parents[x]) {
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParnet = find(y);
            if(xParent == yParnet) return;
            parents[xParent] = yParnet; 
            count--;
        }
    }
}
