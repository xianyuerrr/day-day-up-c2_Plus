#include <bits/stdc++.h>

using namespace std;

int main() {
    int x;
    scanf("%d", &x);
    for (int i = 2; i < x; i++) {
        if (x % i == 0) {
            printf("not prime");
            return 0;
        }
    }
    printf("prime");
    return 0;
}
