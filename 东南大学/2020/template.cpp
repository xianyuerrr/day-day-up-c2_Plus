#include <iostream>
using namespace std;

template <typename T1, typename T2>
class A {
    public:
        T1 a;
        T2 b;
        A() {}
        A(T1 a, T2 b) {
            this->a = a;
            this->b = b;
        }
};

int main() {
    A<int, char> c1(1, 'c');
    // A<int, char> *c1 = new A<int, char>(1, 'c');
    cout << c1.a << endl;
    cout << c1.b << endl;
    return 0;
}