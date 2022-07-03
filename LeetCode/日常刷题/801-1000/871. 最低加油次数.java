import java.util.Arrays;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return method2(target, startFuel, stations);
    }

    /**
     * description 一维dp
     */
    public int method2(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long [] dp = new long [n+1];
        // dp[i]: 加 i 次油能到达的最远距离
        dp[0] = startFuel;
        for (int i = 1; i < n+1; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dp[j] < stations[i-1][0]) break;
                dp[j+1] = Math.max(dp[j+1], dp[j] + stations[i-1][1]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }

    /**
     * description 二维dp
     */
    public int method1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // 0 <= n <= 500
        if (n == 0) return startFuel >= target ? 0 : -1;
        long [][] dp = new long [n+1][n+1];
        int [] dis = new int [n+1];
        for (int i = 1; i < n+1; i++) dis[i] = stations[i-1][0];
        for (int i = 0; i < n+1; i++) Arrays.fill(dp[i], -1);
        // dp[i][j]: 行驶到第 i 个 station 时，加 j 次油，剩余的最大油量
        dp[0][0] = startFuel;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = i-1; k >= 0; k--) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] - (dis[i] - dis[k]));
                    if (j == 0 || dp[k][j-1] < dis[i] - dis[k]) break;
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] - (dis[i] - dis[k]) + stations[i-1][1]);
                }
            }
        }
        for (int j = 0; j < n+1; j++) {
            if (dp[n][j] >= target - stations[n-1][0]) return j;
        }
        return -1;
    }
}