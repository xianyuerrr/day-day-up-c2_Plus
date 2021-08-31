#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, ans;
    scanf("%d", &N);
    int nums[N+1];

    fill(nums, nums+N+1, true);

    for (int i = 2; i <= N; i++) {
        if (nums[i]) {
            printf("%d\n", i);
            ans = i + i;
            while (ans <= N) {
                nums[ans] = false;
                ans += i;
            }
        }
    }
    return 0;
}
