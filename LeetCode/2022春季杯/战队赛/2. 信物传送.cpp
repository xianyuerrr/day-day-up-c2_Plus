#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, b) for (int i=a; i < (b); i++)
#define trav(a, x) for (auto& a : x)

typedef long long ll;

class Solution {
public:
    int dis[105][105];
    int dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};
    string dir = "v^><";
    int conveyorBelt(vector<string>& matrix, vector<int>& start, vector<int>& end) {
        int n = matrix.size(), m = matrix[0].size();
        memset(dis, 0x3f, sizeof dis);
        queue<pair<int, int>> que;
        dis[start[0]][start[1]] = 0;
        que.emplace(start[0], start[1]);
        while (!que.empty()) {
            auto cur = que.front();
            que.pop();
            int x = cur.first, y = cur.second;
            int s = find(dir.begin(), dir.end(), matrix[x][y]) - dir.begin();
            for (int i = 0; i < 4; ++i) {
                int x1 = x + dx[i], y1 = y + dy[i];
                if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
                if (dis[x1][y1] > dis[x][y] + (i != s)) {
                    dis[x1][y1] = dis[x][y] + (i != s);
                    que.emplace(x1, y1);
                }
            }
        }
        return dis[end[0]][end[1]];
    }
};