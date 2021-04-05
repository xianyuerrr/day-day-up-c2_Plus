#include <bits/stdc++.h>

using namespace std;

int main() {
   double a, b;
   while (scanf("%lf%lf", &a, &b) != EOF) {
        if (a > b) a, b = b, a;
        do {
           if (a > b) {
               a = b + a;
               b = a - b;
               a = a - b;
           }
           b %= a;
        //    cout << a << ',' << b << endl;
        } while (b % a != 0);
        printf("%lf", a);
    //    for (int i{a}; i > 0; i--) {
    //        if (a % i == 0 && b % i == 0) {
    //            printf("%lf", i);
    //            break;
    //        }
    //    }
   }
   return 0;
}
