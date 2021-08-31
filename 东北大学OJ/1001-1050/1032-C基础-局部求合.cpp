#include <bits/stdc++.h>
#define N (20)
using namespace std;

int main() {
    vector<int> nums;
    // const int N{20};
    int ans;
    for (int idx{0}; idx < N; idx++) {
        scanf("%d", &ans);
        nums.push_back(ans);
    }
    for (int i{0}; i < N; i++) {
        for (int j{0}; j < N; j++) {
            if (i == j) continue;
            if (nums[i] % nums[j] == 0) {
                printf("%d\n", nums[i]);
                break;
            }
        }
    }
    return 0;
}
