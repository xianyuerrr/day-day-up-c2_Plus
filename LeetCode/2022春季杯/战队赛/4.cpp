#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, b) for (int i=a; i < (b); i++)
#define trav(a, x) for (auto& a : x)

typedef long long ll;


class Solution {
    bool ans, used[10][10][10], vis[6];
    char s[15][15],t[15][15];
    vector<string> B,v[6][8];
    int n;

inline bool & get(int t, int x, int y) {
    if (t < 2) {
        return (t == 0) ? used[0][x][y] : used[n - 1][x][y];
    }
    if (t < 4) {
        return (t == 3) ? used[x][0][y] : used[x][n - 1][y];
    }
    return (t == 5) ? used[x][y][0] : used[x][y][n - 1];
}

void dfs(int cur) {
    if (cur == 6) { ans = true; return; }
    for (int i = 0; i < 6; ++i) if (!vis[i]) {
        for (int t = 0; t < 8; ++t) {
            auto &m = v[cur][t];
            bool valid = true;
            for (int x = 0; x < n && valid; ++x) {
                for (int y = 0; y < n && valid; ++y) {
                    if (m[x][y] == '1') {
                        if (get(i, x, y)) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            if (!valid) {
                continue;
            }
            for (int x = 0; x < n && valid; ++x) {
                for (int y = 0; y < n && valid; ++y) {
                    if (m[x][y] == '1') {
                        get(i, x, y) = true;
                    }
                }
            }
            vis[i] = true;
            dfs(cur + 1);
            if (ans) {
                return;
            }
            for (int x = 0; x < n && valid; ++x) {
                for (int y = 0; y < n && valid; ++y) {
                    if (m[x][y] == '1') {
                        get(i, x, y) = false;
                    }
                }
            }
            vis[i] = false;
        }
    }
}
public:
    bool composeCube(vector<vector<string>>& shapes) {
        int C=0;
		for (vector<string> &A : shapes) {
			n=(int)A.size();
			B=A;
			for (int i=0;i<n;i++) for (int j=0;j<n;j++) s[i][j]=A[i][j];
			int C2=0;
			for (int a=0;a<4;a++) {
				for (int i=0;i<n;i++) {
					B[i].clear(); for (int j=0;j<n;j++) B[i].push_back(s[i][j]);
				}
				v[C][C2]=B; C2++;
				for (int i=0;i<n;i++) reverse(B[i].begin(),B[i].end());
				v[C][C2]=B; C2++;
				for (int i=0;i<n;i++) for (int j=0;j<n;j++) {
					t[j][n-i-1]=s[i][j];
				}
				for (int i=0;i<n;i++) for (int j=0;j<n;j++) s[i][j]=t[i][j];
			}
            C++;
		}
        int sum = 0;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    sum += shapes[i][j][k] - '0';
                }
            }
        }
        if (sum != n * n * n - (n - 2) * (n - 2) * (n - 2)) {
            return false;
        }
        ans = false;
        dfs(0);        
        return ans;
    }
};
