#include <iostream>
using namespace std;

int func(int x, int &y) {
    static int c = 3;
    c++;
    y = x + c;
    return y;
}

int main() {
    int a=2, b=0;
    for (int i=0; i<3; i++) {
        func(a, b);
        cout << b << endl;
    }
    return 0;
}