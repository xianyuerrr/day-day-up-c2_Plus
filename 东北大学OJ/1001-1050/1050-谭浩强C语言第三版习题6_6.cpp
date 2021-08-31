#include <bits/stdc++.h>

using namespace std;

int main() {
    for (int a{1}; a <= 9; a++) {
        for (int b{0}; b <= 9; b++) {
            for (int c{0}; c <= 9; c++) {
                if (pow(a, 3) + pow(b, 3) + pow(c, 3) == a * 100 + b * 10 + c) {
                    printf("%d%d%d\n", a, b, c);
                }
            }
        }
    }
    return 0;
}
