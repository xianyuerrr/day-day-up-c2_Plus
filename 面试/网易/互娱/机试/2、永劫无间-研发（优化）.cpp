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
        }

        int lidx, ridx;
        int res=0;
        
        lidx = ridx = m-1;
        while (lidx > -1 && high[lidx] <= high[m-1]) {
            lidx--;
        }
        while (ridx < n && high[ridx] <= high[m-1]) {
            ridx++;
        }
        // 分别在 (-1, lidx) 与 (ridx, n-1) 寻找有几个谷底（即 101 型）

        // 设置 ll 是为了避免 重复计算一个谷底
        bool flag = false;
        for (int i=1; i<lidx; i++) {
            if (high[i] > high[i-1] && !flag) {
                res += 1;
                flag = true;
            } else if (high[i] < high[i-1] && flag) {
                flag = false;
            }
        }

        flag = false;
        for (int i=n-1; i>ridx; i--) {
            if (high[i] > high[i+1] && !flag) {
                res += 1;
                flag = true;
            } else if (high[i] < high[i+1] && flag) {
                flag = false;
            }
        }
        cout << res << endl;
    }
    return 0;
}


// 3
// 5 1
// 0 1 0 1 0
// 7 1
// 0 1 0 0 2 1 0
// 7 2
// 0 1 0 0 2 1 0