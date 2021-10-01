#include <bits/stdc++.h>

using namespace std;

int main() {
    long x, y, m;
    long res=0;
    cin >> x >> y >> m;
    if (x > y) {
        swap(x, y);
    }
    if (y <= 0 && y < m) {
        res = -1;
    } else {
        if ( x < 0) {
            res += (-x) / y + 1;
            x += ((-x) / y + 1) * y;
        }
        while (y < m) {
            x += y;
            swap(x, y);
            res += 1;
        } 
    }
    cout << res << endl;
    return 0;
}
