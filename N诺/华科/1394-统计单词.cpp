#include <bits/stdc++.h>

using namespace std;

int main() {
    string s;
    getline(cin, s);
    int len{0};
    for (char c : s) {
        if (c == ' ' || c == '.')
        {
            if (len != 0) {
                printf("%d ", len);
                len = 0;
            }
        }
        else {
            len++;
        }
    }
    return 0;
}
