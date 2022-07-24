import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= m * n;
        List<Integer> lis = new ArrayList<>(k);
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (k > lis.size()) lis.add(grid[i][j]);
                int ans = i * n + j - k;
                if (ans < 0) {
                    grid[i][j] = lis.get(-ans-1);
                } else {
                    int nextI = ans / n, nextJ = ans % n;
                    grid[i][j] = grid[nextI][nextJ];
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                ans.add(grid[i][j]);
            }
            res.add(ans);
        }
        return res;
    }
}