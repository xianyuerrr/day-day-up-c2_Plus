#include <bits/stdc++.h>

using namespace std;

int main() {
    int T;
    cin >> T;
    while (T-- > 0) {
        int n, m;
        cin >> n >> m;
        // 找到每个位置左右两侧第一个更高的位置
        int l[n], r[n], high[n];
        for (int i=0; i < n; i++) {
            cin >> high[i];
            l[i] = -1;
            r[i] = n;
        }

        stack<int> stk;
        for (int i=0; i<n; i++) {
            while (!stk.empty() && high[stk.top()] < high[i]) {
                r[stk.top()] = i;
                stk.pop();
            }
            stk.push(i);
        }
        while(!stk.empty()) {
            stk.pop();
        }

        for (int i=n-1; i>=0; i--) {
            while (!stk.empty() && high[stk.top()] < high[i]) {
                l[stk.top()] = i;
                stk.pop();
            }
            stk.push(i);
        }
        while(!stk.empty()) {
            stk.pop();
        }



        int lidx, ridx;
        int res=0;
        lidx = l[m-1];
        ridx = r[m-1];
        // 分别在 (-1, lidx) 与 (ridx, n-1) 寻找有几个谷底（即 101 型）

        // 设置 ll 是为了避免 重复计算一个谷底
        int ll = -1;
        for (int i=0; i<lidx; i++) {
            bool flag = true;
            if (r[i] > lidx || i < ll) {
                continue;
            }
            for (int k=l[i]; k < r[i]; k++) {
                if (k == -1 || k == n) {
                    continue;
                }
                if (high[k] < high[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += 1;
                ll = r[i];
            }
        }
        ll = ridx;
        for (int i=ridx+1; i<n; i++) {
            bool flag = true;
            if (l[i] < ridx || i < ll) {
                continue;
            }
            for (int k=l[i]; k < r[i]; k++) {
                if (k == -1 || k == n) {
                    continue;
                }
                if (high[k] < high[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += 1;
                ll = r[i];
            }
        }

        cout << res << endl;
    }
    return 0;
}
