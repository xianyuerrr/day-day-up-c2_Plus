#include <bits/stdc++.h>

using namespace std;

int main() {
    int row;
    cin >> row;
    while (row != 0) {
        row--;
        int num, a=0;
        cin >> num;
        vector<int> res;
        while (num != 0) {
            a = num % 10;
            num /= 10;
            if (a == 0) {
                if (!res.empty() && res[res.size()-1] == 1) {
                    res.push_back(0);
                }
                continue;
            }
        
            while (a != 0) {
                if (a & 1 == 1) {
                    // c++不能使用 res[-1] 来访问 res 的最后一个元素
                    if (res.empty() || res[res.size()-1] == 0) {
                        res.push_back(1);
                    }
                } else {
                    if (!res.empty() && res[res.size()-1] == 1) {
                        res.push_back(0);
                    }
                }
                a >>= 1;
            }
            // for (int i : res) {
            //     cout << i << ' ';
            // }
            // cout << endl;
        }
        if (res.empty()) {
            cout << 0;
        } else {
            for (int i : res) {
                cout << i;
            }
        }
        cout << endl;
        res.clear();
    }
    return 0;
}
