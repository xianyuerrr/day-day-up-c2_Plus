import java.util.Arrays;

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int res = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        int [] dp1 = new int [n];
        int [] dp2 = new int [n];
        int [] ans;
        Arrays.fill(dp1, 0);
        for (int i = 0; i < m-1; i++) {
            Arrays.fill(dp2, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                dp1[j] += grid[i][j];
                for (int k = 0; k < n; k++) {
                    dp2[k] = Math.min(dp2[k], dp1[j] + moveCost[grid[i][j]][k]);
                }
            }
            ans = dp1; dp1 = dp2; dp2 = ans;
        }
        for (int j = 0; j < n; j++) res = Math.min(res, grid[m-1][j] + dp1[j]);
        return res;
    }
}