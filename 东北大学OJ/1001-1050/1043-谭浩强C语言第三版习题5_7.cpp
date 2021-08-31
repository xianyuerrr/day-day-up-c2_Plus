#include <bits/stdc++.h>

using namespace std;

int main() {
    int l, ans, res{0};
    vector<int> v;
    scanf("%d", &ans);
    if (ans == 0) {
        printf("1\n0\n0");
        return 0;
    }
    while (ans != 0) {
        v.push_back(ans % 10);
        res = res * 10 + ans % 10;
        ans /= 10;
    }
    printf("%d\n", v.size());
    for (int i=v.size()-1; i >= 0; i--) {
        printf("%d", v[i]);
        if (i != 0) printf(" ");
    }
    printf("\n%d", res);
    return 0;
}
