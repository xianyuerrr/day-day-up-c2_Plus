#include <bits/stdc++.h>

using namespace std;

int main() {
    vector<int> v;
    int ans;

    int N;
    scanf("%d", &N);
    for (int num{2}; num <= N; num++) {
        ans = 0;
        v.clear();
        for (int i{1}; i < num; i++) {
            if (num % i == 0) {
                ans += i;
                v.push_back(i);
            }
        }
        if (ans == num) {
            printf("%d its factors are ", num);
            for (int i : v) {
                printf("%d ", i);
            }
            printf("\n");
        }
    }
    return 0;
}
