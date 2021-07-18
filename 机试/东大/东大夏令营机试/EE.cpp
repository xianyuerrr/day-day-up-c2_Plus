#include <bits/stdc++.h>

using namespace std;

int main() {
    stack<char> stk;
    int row;
    string s;
    bool flag;

    cin >> row;

    while (row--) {
        flag = true;
        cin >> s;
        for (char c : s) {
            if (c == ')') {
                if (!stk.empty() && stk.top() == '(') {
                    stk.pop();
                } else {
                    flag = false;
                    break;
                }
            } else {
                stk.push(c);
            }
        }
        if (flag && stk.empty()) {
            cout << "Yes" << endl;
        } else {
            cout << "No" << endl;
        }
        while (!stk.empty()) {
            stk.pop();
        }
    }
    
    return 0;
}
