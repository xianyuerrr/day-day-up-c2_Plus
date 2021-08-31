#include <bits/stdc++.h>

using namespace std;

int main() {
    int m, n;
    scanf("%d%d", &m, &n);
    double high = m, distance = 0;
    while (n-- > 0) {
        distance += high * 1.5;
        high /= 2;
    }
    // 落地时，由于 distance 计算的是反弹后到达最高处时的总距离
    // 所以还应减去 high
    printf("%.2lf %.2lf", high, distance-high);
    return 0;
}
