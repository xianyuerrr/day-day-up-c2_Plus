#include <bits/stdc++.h>
using namespace std;

int main() {
  int a{0}, b{0}, row;
  int ans, count{0};
  // cin >> row;
  scanf("%d", &row);

  while (row-- > 0) {
    scanf("%d", &ans);
    for (int i{1}; i<=sqrt(ans); i++) {
      if (ans%i == 0) {
        count += 2;
        if (i == sqrt(ans)) count--;
      }
    }
    printf("%d\n", count);
    count = 0;
  }
  // cout << a*b << endl; 
  return 0;
}