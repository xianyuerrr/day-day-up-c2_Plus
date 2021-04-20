#include <bits/stdc++.h>

using namespace std;

int main() {
    int N;
    int count = 1;
    scanf("%d", &N);
    while(N-- > 1) {
        count++;
        count *= 2;
    }
    printf("%d", count);
    return 0;
}
