class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 1 <= m, n <= 100
        // 从 [0, 0] -> [m-1, n-1]，由于只能往右、下，所以一共 m+n-1 步
        // 若长度为奇数，则必不可能存在合法字符串
        if ((m+n-1 & 1) == 1) return false;
        // 若 [0, 0] 不为 '('，或者 [m-1, n-1] 不为 ')'，很显然也不能构成合法字符串
        if (grid[0][0] != '(' || grid[m-1][n-1] != ')') return false;

        int k = 100;
        boolean [][][] dp = new boolean [m][n][k];
        dp[0][0][1] = true;

        int diff;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int v = 0; v < k; v++) {
                    if (grid[i][j] == '(') diff = 1;
                    else diff = -1;
                    
                    int ans = v - diff;
                    if (ans < 0 || ans >= k || v > (m+n-1) - (i+j+1)) continue;
                    dp[i][j][v] |= i-1 >= 0 ? dp[i-1][j][v - diff] : false;
                    dp[i][j][v] |= j-1 >= 0 ? dp[i][j-1][v - diff] : false;
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}