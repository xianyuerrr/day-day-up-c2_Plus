#include <bits/stdc++.h>

using namespace std;

int main() {
    int row;
    long a, b, c, c_max, c_min;

    cin >> row;

    while (row--) {
        c_min = c_max = -1;
        cin >> a >> b;
        if (a > b) { swap(a, b); }
        
        for (c=2; c <= b-a; c++) {
            if (a % c == b % c) {
                c_min = c;
                break;
            }
        }
        for (c=b-a; c > 1; c--) {
            if (a % c == b % c) {
                c_max = c;
                break;
            }
        }

        cout << c_min << ' ' << c_max << endl;
    }

    return 0;
}
