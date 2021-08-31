#include <bits/stdc++.h>

using namespace std;

int main() {
    double a, b, c;
    double res{0};
    scanf("%lf%lf%lf", &a, &b, &c);
    for (int i{1}; i <= a; i++) {
        res += i;
    }
    for (int i{1}; i <= b; i++) {
        res += i*i;
    }
    for (double i{1}; i <= c; i++) {
        res += 1/i;
    }
    printf("%.2lf", res);
    return 0;
}
