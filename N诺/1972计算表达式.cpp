#include <bits/stdc++.h>
using namespace std;

int main() {
    int rows;
    bool p, a, t;
    string s;
    scanf("%d", &rows);
    getchar();
    while (rows-- > 0) {
        p = false;
        a = false;
        t = false;
        getline(cin, s);
        for (int i{0}; i < s.size(); i++) {
            if (s[i] == 'P') {
                p = true;
            } else if (s[i] == 'A') {
                a = true;
            } else if (s[i] == 'T') {
                t = true;
            }
            else{
              p = false;
              break;
            }
        }
        if (p && a && t) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
    }
}