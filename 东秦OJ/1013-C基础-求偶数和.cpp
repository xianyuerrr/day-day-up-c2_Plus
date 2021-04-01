#include <bits/stdc++.h>
using namespace std;

int main() {
    int count, res, ans;
    res = 0;
    scanf("%d", &count);
    while (count-- > 0) {
        scanf("%d", &ans);
        if (ans % 2 == 0) res += ans;
    }
    printf("%d", res);
    return 0;
}