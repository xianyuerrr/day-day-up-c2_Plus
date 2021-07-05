#include <bits/stdc++.h>

using namespace std;

int main() {
    string A;
    int B;
    while (cin>>A>>B) {
        int length = A.size();
        int ans = 0;
        vector<int> res(length, 0);
        for (int i=0; i < length; i++) {
            ans = ans * 10 + A[i] -'0';
            res[i] = ans / B;
            ans = ans % B;
        }
        int begin;
        for (begin=0; begin < length; begin++) {
            if (res[begin] != 0) {break;}
        }
        for (; begin < length; begin++) {
            cout<<res[begin];
        }
        cout << ' ';
        cout << ans << endl;
    }

    return 0;
}
