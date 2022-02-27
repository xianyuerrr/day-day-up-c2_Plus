#include <iostream>
using namespace std;

class A {
    public:
        A() {
            cout << "A1" << endl;
        }
        
        ~A() {
            cout << "A2" << endl;
        }
};

class B : public A {
    public:
        B() {
            cout << "B1" << endl;
        }

        ~B() {
            cout << "B2" << endl;
        }
        
        void print() {
            cout << "B3" << endl;
        }
};

int main() {
    B b;
    b.print();
    return 0;
}