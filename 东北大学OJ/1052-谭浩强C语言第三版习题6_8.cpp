#include <bits/stdc++.h>

using namespace std;

int main() {
    int up{2}, down{1};
    double res{0};
    int N;
    scanf("%d", &N);
    while (N-- > 0) {
        res += (double)up / down;
        up += down;
        down = up - down;
    }
    printf("%.2lf", res);
    return 0;
}
