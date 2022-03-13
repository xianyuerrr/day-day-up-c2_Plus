#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    int vals[n] = {0};
    
    for (int i = 0; i < n; i++) { cin >> vals[i]; }

    int nextBigger[n] = {0}, nextSmaller[n] = {0};
    
    // 单调栈求下一个最大最小值
    stack<int> sB, sM;
    sB.push(0); sM.push(0);

    // 初始化 nextBigger, nextSmaller
    for (int i = 1; i < n; i++) {
        while (!sB.empty() && vals[sB.top()] < vals[i]) {
            nextBigger[sB.top()] = i;
            sB.pop();
        }
        sB.push(i);

        while (!sM.empty() && vals[sM.top()] > vals[i]) {
            nextSmaller[sM.top()] = i;
            sM.pop();
        }
        sM.push(i);
    }

    while (!sB.empty()) {
        nextBigger[sB.top()] = n;
        sB.pop();
    }
    while (!sM.empty()) {
        nextSmaller[sM.top()] = n;
        sM.pop();
    }

    int l, r, ans, lowest, highest;
    while (k-- > 0) {
        cin >> l >> r;
        l--;
        lowest = l;
        highest = l;

        while (nextSmaller[lowest] < r) {
            lowest = nextSmaller[lowest];
        }
        while (nextBigger[highest] < r) {
            highest = nextBigger[highest];
        }
        ans = vals[highest] - vals[lowest];
        cout << ans << endl;
    }

    return 0;
}

// 6 3
// 2
// 8
// 4
// 5
// 3
// 6
// 1 5
// 2 2
// 4 6