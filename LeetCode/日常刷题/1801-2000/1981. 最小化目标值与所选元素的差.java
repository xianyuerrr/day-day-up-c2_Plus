import java.util.Arrays;

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        // 存在和大于 target 的情况，没有建立这么大背包的必要，只消找到最小的那个便是
        int res = 0;
        int m = mat.length, n = mat[0].length;
        // 1 <= m, n <= 70
        // 1 <= mat[i][j] <= 70
        // 1 <= target <= 800

        // 背包问题，dp[i][j]: 前 i 行选完能否选出值为 j 的组合
        boolean [][] dp = new boolean [m+1][target];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            Arrays.sort(mat[i]);
            res += mat[i][0];
            for (int j = 0; j < target; j++) {
                if (!dp[i][j]) continue;
                for (int k = 0; k < n; k++) {
                    if (j + mat[i][k] >= target) {res = res >= target ? Math.min(res, j + mat[i][k]) : j + mat[i][k]; break;}
                    dp[i+1][j+mat[i][k]] = true;
                }
            }
        }
        res = res >= target ? res - target : Integer.MAX_VALUE;
        int l = target-1;
        while (l >= 0) {
            if (dp[m][l]) {res = Math.min(res, target - l); break;}
            l--;
        }
        return res;
    }
}