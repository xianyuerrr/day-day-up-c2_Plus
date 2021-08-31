#include <bits/stdc++.h>
#define order (1333)
using namespace std;

int main() {
    int num1, num2;
    for (int a{0}; a < 10; a++) {
        for (int b{0}; b < 10; b++) {
            for (int c{0}; c < 10; c++) {
                num1 = c + b*10 + a*100;
                num2 = a + b*10 + c*100;
                if (num1 + num2 == order) {
                    printf("%d+%d=%d\n", num1, num2, order);
                }
            }
        }
    }
    return 0;
}
