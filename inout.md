import sys 
for line in sys.stdin:
    a = line.split()
    print(int(a[0]) + int(a[1]))

#include <iostream>
using namespace std;
int main() {
    int a,b; while(cin >> a >> b)//注意while处理多个case
        cout << a+b << endl;
}