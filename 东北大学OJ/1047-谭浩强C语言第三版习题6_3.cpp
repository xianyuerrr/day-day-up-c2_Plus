#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, res{0};
    scanf("%d", &n);
    for (int a=0; a <= n; a++) {
        res += 2 * pow(10, a) * (n-a);
    }
    printf("%d", res);
    return 0;
}
