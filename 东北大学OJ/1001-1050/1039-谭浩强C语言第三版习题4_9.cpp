#include <bits/stdc++.h>

using namespace std;
double f(double t) {
    return 5 * (t-32) / 9;
}

int main() {
    double t;
    scanf("%lf", &t);
    printf("c=%.2lf", f(t));
    return 0;
}
