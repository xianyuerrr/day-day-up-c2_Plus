#include <bits/stdc++.h>

using namespace std;

int main() {
    int a{0}, b{0};
    for (int idx{0}; idx < 3; idx++) {
        scanf("%d", &b);
        a = a >= b ? a : b;
    }
    printf("%d", a);
    return 0;
}
