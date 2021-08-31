#include <bits/stdc++.h>
# define PI (acos(-1))
using namespace std;

int main() {
    int r;
    double area;
    for (r = 1; r <= 10; r++) {
        area = PI * pow(r, 2);
        if (area >= 40 && area <= 90) {
            printf("r=%d area=%.2lf\n", r, area);
        }
    }
    return 0;
}
