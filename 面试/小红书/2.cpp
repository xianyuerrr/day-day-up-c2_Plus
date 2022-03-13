#include <bits/stdc++.h>

using namespace std;

int main() {
    int mod = pow(10, 9) + 7;
    int m, n, k;
    cin >> m >> n >> k;
    int dp[m][n];
    int x, y;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            dp[i][j] = 0;
        }
    }
    for (int i = 0; i < k; ++i) {
        cin >> x >> y;
        dp[x-1][y-1] = -1;
    }
    dp[0][0] = 1;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i == 0 && j == 0) {continue;}
            if (dp[i][j] == -1) {continue;}
            dp[i][j] = (j-1 >= 0 && dp[i][j-1] != -1 ? dp[i][j-1] : 0) + 
                (i-1 >= 0 && dp[i-1][j] != -1 ? dp[i-1][j] : 0);
            dp[i][j] %= mod;
        }
    }
    // for (int i = 0; i < m; ++i) {
    //     for (int j = 0; j < n; ++j) {
    //         cout << dp[i][j] << ", ";
    //     }
    //     cout << endl;
    // }
    cout << dp[m-1][n-1] << endl;
    return 0;
}

// 3 4 2 
// 2 2 
// 2 3

// 100 100 3
// 15 16
// 16 15
// 99 88