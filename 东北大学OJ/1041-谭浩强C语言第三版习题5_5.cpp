#include <bits/stdc++.h>

using namespace std;

int main() {
    int x;
    scanf("%d", &x);
    printf("%d", x < 1 ? x : (x < 10 ? 2*x-1 : 3*x-11));
    return 0;
}
