import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], i-2 >= 0 ? (dp[i-2] + cost[i-2]) : 0);
        }
        return dp[n];
    }
}