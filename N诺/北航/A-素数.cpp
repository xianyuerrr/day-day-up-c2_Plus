#include <iostream>
using namespace std;

int main() {
    int n;
    cin>>n;

    if (n < 11) {
        cout<<-1;
        return 0;
    }

    int idx = 11;
    cout<<idx;
    idx += 10;
    bool flag;
    while (idx <= n) {
        flag = true;
        for (int i=2; i * i <= n; i++) {
            if (idx % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            cout<<' '<<idx;
        }
        idx += 10;
    }
    return 0;
}