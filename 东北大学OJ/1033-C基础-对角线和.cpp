#include <bits/stdc++.h>

using namespace std;

int main() {
    const int n{3};
    int res{0};
    int ans;
    for (int idx{1}; idx <= n*n; idx++) {
        scanf("%d", &ans);
        if (idx == 1 or idx == 5 or idx == 9) {
            res += ans;
        }
    }
    printf("%d", res);
    // 矩阵法
    // vector<vector<int>> mat(n, vector<int>(n, 0));
    // for (int x{0}; x < n; x++) {
    //     for (int y{0}; y < n; y++) {
    //         scanf("%d", &mat[x][y]);
    //     }
    // }
    // printf("%d", mat[0][0] + mat[1][1] + mat[2][2]);
    return 0;
}
