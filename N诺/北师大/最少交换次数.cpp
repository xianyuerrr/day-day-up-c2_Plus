#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    // 求这个数前面比他大的数的个数

    vector<int> lis(n, 0);
    vector<int> cnt(n, 0);

    for (int i = 0; i < n; i++) {
        cin >> lis[i];
    }

    // for (int i=0; i < n; i++) {
    //     for (int j=0; j < i; j++) {
    //         if (lis[j] > lis[i]) {
    //             cnt[i] += 1;
    //         }
    //     }
    // }
    // for (int i=0; i < n; i++) {
    //     for (int j=0; j < n-1-i; j++) {
    //         if (lis[j] > lis[j+1]) {
    //             swap(lis[j], lis[j+1]);
    //             swap(cnt[j], cnt[j+1]);
    //         }
    //     }
    // }

    for (int i=0; i < n-1; i++) {
        for (int j=0; j < n-1; j++) {
            if (lis[j] > lis[j+1]) {
                swap(lis[j], lis[j+1]);
                swap(cnt[j], cnt[j+1]);
                cnt[j] += 1;
            }
        }
    }
    
    int res=0;
    for (int i=0; i < n; i++) {
        cout << cnt[i];
        if (i != n-1) {cout << ' ';};
        res += cnt[i];
    }
    cout << endl << res << endl;
    return 0;
}
