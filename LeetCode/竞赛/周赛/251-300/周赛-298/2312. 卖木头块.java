class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        // 沿垂直方向按高度 完全 切割木块，或
        // 沿水平方向按宽度 完全 切割木块
        // 可以切割木块任意次
        // 不需要将所有小木块都卖出去
        // 你 不能 旋转切好后木块的高和宽
        // 返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数
        // 1 <= m, n <= 200
        // 1 <= prices.length <= 2 * 10^4
        // 1 <= hi <= m
        // 1 <= wi <= n
        // 1 <= pricei <= 106
        // 所有 (hi, wi) 互不相同 

        var map = new int[m + 1][n + 1];
        for (var p : prices) map[p[0]][p[1]] = p[2];

        var dp = new long[m + 1][n + 1];
        for (var i = 1; i <= m; i++)
            for (var j = 1; j <= n; j++) {
                dp[i][j] = map[i][j];
                for (var k = 1; k < i; k++) dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]); // 水平切割
                for (var k = 1; k < j; k++) dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]); // 垂直切割
            }
        return dp[m][n];
    }
}