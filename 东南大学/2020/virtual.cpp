#include <iostream>
using namespace std;

class A
{
public:
    // 纯虚函数
    // virtual void func1()=0;
    virtual void foo()
    {
        cout<<"A::foo() is called"<<endl;
    }
};

class B : public A
{
public:
    void foo()
    {
        cout<<"B::foo() is called"<<endl;
    }
};

class C : public A
{
public:
    void foo()
    {
        cout<<"C::foo() is called"<<endl;
    }
};


int main(void)
{
    A *a1 = new B();
    A *a2 = new C();
    a1->foo();   // 在这里，a虽然是指向A的指针，但是被调用的函数(foo)却是B的!
    a2->foo();
    return 0;
}