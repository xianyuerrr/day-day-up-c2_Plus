#include <bits/stdc++.h>

using namespace std;

int main() {
    const int line1{6};
    const int line2{8};
    vector<int> v1(line1), v2(line2);
    for (int idx{0}; idx < line1; idx++) {
        scanf("%d", &v1[idx]);
    }
    for (int idx{0}; idx < line2; idx++) {
        scanf("%d", &v2[idx]);
    }
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    for (int x{0}; x < line1; x++) {
        for (int y{0}; y < line2; y++) {
            if (v1[x] == v2[y]) {
                printf("%d\n", v1[x]);
                break;
            }
        }
    }
    return 0;
}
