#include <bits/stdc++.h>

using namespace std;


int gcd(int x, int y) {
    if (x > y) return gcd(y, x);
    else if (y % x == 0) return x;
    return gcd(y % x, x);
}


int main() {
    int x, y;
    scanf("%d%d", &x, &y);
    int a = gcd(x, y);
    int b = x * y / a;
    printf("%d %d", a, b);
    return 0;
}
