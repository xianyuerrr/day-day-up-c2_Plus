#include<bits/stdc++.h>

#define int long long
using namespace std;

const int N = 1e3 + 10 , mod = 202220222022;
int n , res , dp[N][N * 20];
signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0) , cout.tie(0);
    for(int i = 0 ; i <= 20 ; i ++) dp[1][i] = 1;
    cin >> n;
    n += 3;
    for(int i = 2 ; i <= n ; i ++){
        for(int j = 0 ; j <= i * 20 ; j ++){
            for(int k = 0 ; k <= min(20ll , j) ; k ++){
                dp[i][j] += dp[i - 1][j - k];
                dp[i][j] %= mod;
            
        }
    }
    for(int i = n * 12 ; i <= n * 20 ; i ++) {
        res = (res + dp[n][i]) % mod;
    }
    cout << res << '\n';
    return 0;
}