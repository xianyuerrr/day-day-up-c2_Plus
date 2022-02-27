#include <iostream>
#include <iomanip>
using namespace std;

int x = 6;

int main() {
    int x = 5;
    {
        int x = 0;
        cout << x++ << endl;
        cout << ++x << endl;
        cout << x << endl;
    }
    if (x / 2) {
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
    return 0;
}