#include <bits/stdc++.h>

using namespace std;

int main() {
    double a, b, c;
    double x;
    double detle;
    scanf("%lf%lf%lf", &a, &b, &c);
    x = - b / (2 * a);
    detle = pow(b, 2) - 4 * a * c;
    if (detle > 0) {
        printf("x1=%.3lf x2=%.3lf", x + sqrt(detle)/(2 * a), x - sqrt(detle)/(2 * a));
    } else if (detle == 0) {
        printf("x1=%.3lf x2=%.3lf", x, x);
    } else {
        printf("x1=%.3lf+%.3lfi x2=%.3lf-%.3lfi", x, sqrt(-detle)/(2 * a), x, sqrt(-detle)/(2 * a));        
    }
    return 0;
}
