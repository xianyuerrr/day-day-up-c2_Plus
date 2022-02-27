#include <iostream>
using namespace std;

class Employee {
    public:
        char* name;
        int earnings;
        Employee(char* name, int Earnings) {
            this -> name = name;
            this -> earnings = Earnings;
        }
        
        Employee(Employee& e1) {
            this -> name = e1.name;
            this -> earnings = e1.earnings;
        }
        
        void print() {
            cout << earnings << endl;
        }
};

Employee Test(Employee e1) {
    e1.earnings += 100;
}

Employee Test_ref(Employee& e_ref) {
    e_ref.earnings += 100;
}


int main() {
    Employee e1("Tom", 100);
    e1.print();
    Test(e1);
    e1.print();
    Employee e2("Sam", 300);
    Employee &e_ref = e2;
    Test_ref(e_ref);
    e2.print();
    return 0;
}