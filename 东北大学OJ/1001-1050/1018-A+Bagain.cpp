#include <bits/stdc++.h>

using namespace std;

int main() {
    int rows;
    long long a, b;
    scanf("%d", &rows);
    int row{0};
    while (++row <= rows) {
        printf("Case %d", row);
        scanf("%lld%lld", &a, &b);
        printf("%lld + %lld = %lld\n", a, b, a+b);

    }
    
    return 0;
}
