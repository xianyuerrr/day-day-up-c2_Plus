#include <iostream>
using namespace std;

int main () {
    int count;
    cin >> count;
    
    // 有限状态机
    int staus=-1;
    int a, b;
    while (count-- > 0) {
        if (staus == -1 || staus == 0) {
            staus = 1;
            cin >> a;
        } else {
            cin >> b;
            cout << b << ' ' << a ;
            if (count != 0) { cout << ' '; }
            staus = 0;
        }
    }
    if (staus == 1) {
        cout << a;
    }
    return 0;
}