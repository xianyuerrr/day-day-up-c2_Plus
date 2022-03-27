#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        // 方法问题不大，语言影响很大
        int m = matrix.size();
        int n = matrix[0].size();
        int res = INT_MIN, ans;
        int dp[m+1][n+1];
        fill(dp[0], dp[m]+(n+1), 0);
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                dp[x+1][y+1] = dp[x+1][y] + dp[x][y+1] - dp[x][y] + matrix[x][y];
                for (int xx = 0; xx <= x; xx++) {
                    for (int yy = 0; yy <= y; yy++) {
                        ans = dp[x+1][y+1] - dp[xx][y+1] - dp[x+1][yy] + dp[xx][yy];
                        if (ans <= k) res = max(res, ans);
                    }
                }
            }
        }
        return res;
    }
};