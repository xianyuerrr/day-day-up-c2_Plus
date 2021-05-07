#include <bits/stdc++.h>

using namespace std;

int main() {
    string ip;
    cin>>ip;

    int ans = 0;
    int n = ip.length();
    for (char i : ip) {
        if (i == '.') {
            if (0 > ans || ans > 255) {
                cout<<"No!"<<endl;
                return 0;
            }
            ans = 0;
        } else {
            // 前导0
            if (ans == 0 && i == '0') {
                cout<<"No!"<<endl;
                return 0;
            }
            ans = ans * 10 + i - '0';
        }
    }

    if (0 > ans || ans > 255) {
        cout<<"No!"<<endl;
    } else {
        cout<<"Yes!"<<endl;
    }
    return 0;
}
