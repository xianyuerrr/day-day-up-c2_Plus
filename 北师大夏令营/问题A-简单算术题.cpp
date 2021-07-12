#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

vector<ll> dfs(map<ll, map<ll, vector<ll>>> &dic, int n, ll m) {
    if (dic.find(n) != dic.end() && dic[n].find(m) != dic[n].end()) {
        // cout << endl;
        // cout << "已经计算过啦！" << endl;
        // cout << n << ',' << m << endl;
        // cout << dic[n][m][0] << ' ' << dic[n][m][1];
        // cout << endl << endl;
        return dic[n][m];
    }
    vector<ll> ret(2);
    if (n == 1) {
        if (m == 1) {
            ret[0] = 0;
            ret[1] = 1;
        } else {
            ret[0] = 1;
            ret[1] = 0;
        }
        dic[n][m] = ret;
        return ret;
    }
    else {
        if (m % 2 == 0) {
            vector<ll> f1, f2;
            f1 = dfs(dic, n, m-1);
            f2 = dfs(dic, n, m+1);

            ret[0] = f1[0] + f2[0];
            ret[1] = f1[1] + f2[1];
            dic[n][m] = ret;
            return  ret;
        } else {
            ret = dfs(dic, n-1, m/2+1);
            dic[n][m] = ret;
            return ret;
        }
    }
}

int main() {
    ll row, n, m;
    map<ll, map<ll, vector<ll>>> dic;
    cin >> row;
    while (row--) {
        cin >> n >> m;
        vector<ll> res = dfs(dic, n+1, m+1);
        cout << res[0] << '/' << res[1] << endl;
    }
    return 0;
}
