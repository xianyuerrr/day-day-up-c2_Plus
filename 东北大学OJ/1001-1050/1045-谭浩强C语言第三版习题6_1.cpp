#include <bits/stdc++.h>

using namespace std;

int gcd(int x, int y) {
    if (y < x) swap(x, y);
    if (y % x == 0 or x == 1) return x;
    y = y - x * (y / x);
    return gcd(x, y);
}
int main() {
    int a, b;
    scanf("%d%d", &a, &b);
    int g = gcd(a, b);
    int gbs = a * b / g;
    printf("%d %d", g, gbs);
    return 0;
}
