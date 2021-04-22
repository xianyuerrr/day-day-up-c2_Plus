#include <bits/stdc++.h>

using namespace std;

int main() {
    int len = 3;
    int v[len][len];
    int res1 = 0, res2 = 0;
    for (int x = 0; x < len; x++) {
        for (int y = 0; y < len; y++) {
            scanf("%d", &v[x][y]);
            if (x == y) {res1 += v[x][y];}
            if (x + y == len-1) {res2 += v[x][y];}
        }
    }
    printf("%d %d", res1, res2);
    return 0;
}
