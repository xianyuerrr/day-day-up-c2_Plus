#include <bits/stdc++.h>

using namespace std;

int main() {
   int a, b;
   while (scanf("%d%d", &a, &b) != EOF) {
       if (a > b) a, b = b, a;
       while (b % a != 0) {
           b %= a;
           if (a > b) {
               a = b + a;
               b = a - b;
               a = a - b;
           }
        //    cout << a << ',' << b << endl;
       }
       printf("%d", a);
    //    for (int i{a}; i > 0; i--) {
    //        if (a % i == 0 && b % i == 0) {
    //            printf("%d", i);
    //            break;
    //        }
    //    }
   }
   return 0;
}
