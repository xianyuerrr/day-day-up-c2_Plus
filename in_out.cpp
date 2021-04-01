#include <cstdio>
using namespace std;

// while-EOF 型
int main () {
    int a, b;
    while (scanf("%d%d", &a, &b) != EOF) {
        printf("%d\n", a + b);
    }
    return 0;
}
// while-break型
int main () {
    int a, b;
    // 以 a, b 都为0为例
    while (scanf("%d%d", &a, &b) != EOF) {
        if (a == 0 && b ==0) break;
        printf("%d\n", a + b);
    }
    return 0;
}
// or
int main () {
    int a, b;
    while (scanf("%d%d", &a, &b), a || b) {
        printf("%d\n", a + b);
    }
    return 0;
}
// while(T - - )型
int main () {
    int T, a, b;
    scanf("%d", &T);
    while (T--) {
        scanf("%d%d", &a, &b);
        printf("%d\n", a + b);
    }
    return 0;
}