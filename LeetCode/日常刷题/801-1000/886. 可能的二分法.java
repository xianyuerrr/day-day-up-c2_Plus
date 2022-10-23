class Solution {
    int[] lis;
    int length;
    int[][] dislikes;
    final int A = 1;
    final int B = 2;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 1 <= n <= 2000
        // 0 <= dislikes.length <= 10^4
        // ai < bi
        lis = new int[n+1];
        length = dislikes.length;
        this.dislikes = dislikes;
        return dfs(0);
    }

    private boolean dfs(int idx) {
        if (idx == length) return true;
        boolean res = false;
        int x = dislikes[idx][0], y = dislikes[idx][1];
        if (lis[x] == 0 && lis[y] == 0) {
            lis[x] = A;
            lis[y] = B;
            res |= dfs(idx+1);
            lis[x] = B;
            lis[y] = A;
            res |= dfs(idx+1);
            lis[x] = 0;
            lis[y] = 0;
            return res;
        }
        if (lis[x] == lis[y]) return false;

        if (lis[x] == 0) {
            lis[x] = getAnother(lis[y]);
            res |= dfs(idx+1);
            lis[x] = 0;
        } else if (lis[y] == 0) {
            lis[y] = getAnother(lis[x]);
            res |= dfs(idx+1);
            lis[y] = 0;
        }
        return res;
    }

    private int getAnother(int i) {
        return 3 - i;
    }
}