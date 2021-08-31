#include <bits/stdc++.h>

using namespace std;

int main() {
   long long a, b;
   while (cin >> a >> b) {
      // cout << a << ", " << b << endl;
      do {
         if (a > b) {
            swap(a, b);
         }
         if (a == b) {break;}
         b %= a;
      } while (b != 0);
      cout << a << endl;
   }
   return 0;
}
