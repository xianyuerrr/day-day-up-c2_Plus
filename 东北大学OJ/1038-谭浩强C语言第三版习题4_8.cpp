#include<iostream>
using namespace std;
double f(double b) {
    double a = b;
    if (b * 100 > (int)(b * 100)) {
        a = (b + 0.005) * 100 / 100.0;
    }
    return a;
}
int main() {
    double r, h, c1, sa, sb, va, vb;
    scanf("%lf%lf", &r, &h);
    c1 = 3.14 * 2 * r;
    sa = 3.14 * r * r;
    sb = 4 * 3.14 * r * r;
    va = 4 / 3.0 * 3.14 * r * r * r;
    vb = 3.14 * r * r * h;
    printf("C1=%.2lf\nSa=%.2lf\nSb=%.2lf\nVa=%.2lf\nVb=%.2lf", f(c1), f(sa), f(sb), f(va), f(vb));
    return 0;
}