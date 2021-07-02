#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    int ans;
    while (cin>>s) {
        ans = 0;
        for (char i : s) {
            if (i == '.') {
                if (ans < 0 || ans > 255) {
                    cout<<"No!"<<endl;
                    continue;
                }
                ans = 0;
            } else {
                ans = ans * 10 + i - '0';
            }
        }
        if (ans < 0 || ans > 255) {
            cout<<"No!"<<endl;
        } else {
            cout<<"Yes!"<<endl;
        }
    }
    return 0;
}