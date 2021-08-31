#include <bits/stdc++.h>

using namespace std;

int main() {
    double salary, m = 100000;
    scanf("%lf", &salary);
    if (salary <= m) {
        salary *= .1;
    } else if (salary <= 2*m) {
        salary = m * .1 + (salary - m) * .075;
    } else if (salary <= 4 * m) {
        salary = m * .175 + (salary - 2 * m) * .05;
    } else if (salary <= 6 * m) {
        salary = m * .225 + (salary - 4 * m) * .03;
    } else if (salary <= 10 * m) {
        salary = m * .255 + (salary - 6 * m) * .015;
    } else {
        salary = m * .27 + (salary - 10 * m) * .01;
    }
    printf("%d", static_cast<int> (salary));
    return 0;
}
