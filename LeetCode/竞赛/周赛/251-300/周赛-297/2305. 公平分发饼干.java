import java.util.Arrays;

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        // 2 <= cookies.length <= 8
        // 2 <= k <= cookies.length
        int n = cookies.length;

        int [][] dp = new int [k+1][1<<n];
        int [] sum = new int [1<<n];
        
        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) sum[i] += cookies[j];
            }
        }
        dp[1] = sum;
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < 1 << n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int j2 = j; j2 > 0; j2 = (j2 - 1) & j) {
                    // dp[1][0] = 0;
                    // dp[2][1] = min(max(dp[1][1], sum[0]), max(dp[1][0], sum[1]));
                    // dp[3][7] = min(max(dp[2][1], sum[6]), max(dp[2][3], sum[4]), ...);
                    // 虽然存在这种情况，但是容易想到，在这个时候不公平度一定不是最小的。
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][j ^ j2], sum[j2]));
                }
                // System.out.println("i: " + i + ", " + "j: " + j + ", " + "val: " + dp[i][j]);
            }
        }
        return dp[k][(1<<n) - 1];
    }
}