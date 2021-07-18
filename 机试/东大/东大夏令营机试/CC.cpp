#include <bits/stdc++.h>

using namespace std;

int main() {
    int row;
    int x_1, y_1, x_2, y_2, x_3, y_3;
    double k, b, res;
    
    cin >> row;

    while (row--) {
        cin >> x_1 >> y_1 >> x_2 >> y_2 >> x_3 >> y_3;

        if (x_2 == x_1) {
            res = abs(x_3-x_1);
        } else {
            k = (double) (y_2-y_1) / (x_2-x_1);
            b = y_1 - k * x_1;
            res = abs(k*x_3-y_3+b) / sqrt(k*k+1);
        }
        cout<<fixed<<setprecision(2)<<res <<endl;
        // 没想到是没加 endl
    }
    return 0;
}
// 1.00
// 0.70
// 1
