#include <bits/stdc++.h>
using namespace std;

int l{10}, r{1000};
int entire{2*3*7};

int main() {
    for (; l < r+1; l++) {
        if (l % entire == 0) {
            printf("%d\n", l);
        }
    }
    return 0;
}