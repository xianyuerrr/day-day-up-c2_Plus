class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        // 连续 掷出数字 i 的次数不能超过 rollMax[i]
        // 掷 n 次骰子可得到的不同点数序列的数量
        // 至少存在一个元素不同，就认为这两个序列是不同的。
        // 由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
        int res = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        final int KINDS = 6;
        final int ROLLMAX = 15;
        // 1 <= n <= 5000
        int [][][] dp = new int [n][KINDS][ROLLMAX];
        // dp[i][j][k]: 长度为 i+1，结尾为 j+1，且结尾的 j+1 共重复了 k+1 个次
        for (int j = 0; j < KINDS; j++) dp[0][j][0] = 1;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < KINDS; j++) {
                for (int k = 0; k < rollMax[j]; k++) {
                    if (dp[i][j][k] == 0) break;
                    for (int j2 = 0; j2 < KINDS; j2++) {
                        if (j == j2) {
                            if (k+1 < rollMax[j2]) {
                                dp[i+1][j2][k+1] = (dp[i+1][j][k+1] + dp[i][j][k]) % mod;
                            }
                        } else {
                            dp[i+1][j2][0] = (dp[i+1][j2][0] + dp[i][j][k]) % mod;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < KINDS; j++) {
            for (int k = 0; k < ROLLMAX; k++) {
                if (dp[n-1][j][k] == 0) break;
                res = (res + dp[n-1][j][k]) % mod;
            }
        }
        return res % mod;
    }
}