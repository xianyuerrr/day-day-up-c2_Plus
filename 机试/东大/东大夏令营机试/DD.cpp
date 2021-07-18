#include <bits/stdc++.h>

using namespace std;

int main() {
    int row;
    long a[101];
    vector<int> lis;
    cin >> row;
    
    bool flag;
    for (int i=2; i <= 100; i++) {
        flag = true;
        for (int j=2; j<=sqrt(i); j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            lis.push_back(i);
        }
    }

    long res;
    while (row--) {
        res = 0;
        for (int i=1; i<101; i++) {
            cin >> a[i];
        }
        for (int i=0; i<lis.size(); i++) {
            res += a[lis[i]];
        }
        cout << res <<endl;
    } 
    return 0;
}
