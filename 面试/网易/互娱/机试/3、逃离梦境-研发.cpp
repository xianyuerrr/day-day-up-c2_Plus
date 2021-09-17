#include <bits/stdc++.h>

using namespace std;

int main() {
    int T, n, m1, m2;
    cin >> T;
    while (T--) {
        cin >> n >> m1 >> m2;
        vector<vector<int>> hasRoute(n);
        vector<vector<int>> hasDoor(n);
        int x, y;
        while (m1--) {
            cin >> x >> y;
            hasRoute[x-1].push_back(y-1);
            hasRoute[y-1].push_back(x-1);
        }
        while (m2--) {
            cin >> x >> y;
            hasDoor[x-1].push_back(y-1);
            hasDoor[y-1].push_back(x-1);
        }

        int time=0;
        vector<int, int, int> q, nq;
        int x, t;
        while (!q.empty()) {
            for (vector<int> v : q) {
                x = v[0];
                t = v[1];
            }
        }
    }
    return 0;
}
