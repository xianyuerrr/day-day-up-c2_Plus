#include <bits/stdc++.h>
#define N (20)
using namespace std;

int main() {
    vector<int> nums;
    vector<bool> flags;
    int ans;
    for (int idx{0}; idx < N; idx++) {
        scanf("%d", &ans);
        nums.push_back(ans);
    }
    sort(nums.begin(), nums.end());
    for (int i{0}; i < N-1; i++) {
        for (int j=i+1; i < N; j++) {
            if (nums[j] % nums[i] == 0) {
                flags[j] = true;
            }
        }
    }
    for (int idx{0}; idx < N; idx++) {
        printf("--%d", flags[idx]);
        if (flags[idx]) {
            printf("%d\n", nums[idx]);
        }
    }
    return 0;
}
