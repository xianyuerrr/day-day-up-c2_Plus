#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    long long ans{1}, res{0};
    scanf("%d", &n);
    for (int i=1; i <= n; i++) {
        ans *= i;
        res += ans;
    }
    printf("%lld", res);
    return 0;
}
