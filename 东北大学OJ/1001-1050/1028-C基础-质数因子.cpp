#include <bits/stdc++.h>

using namespace std;

int main() {
   int n;
   scanf("%d", &n);
   while (n > 1) {
       for (int i{2}; i <= n; i++) {
           while (n % i == 0) {
               printf("%d ", i);
               n /= i;
           }
       }
   }
   return 0;
}
