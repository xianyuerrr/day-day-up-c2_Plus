#include <bits/stdc++.h>
using namespace std;
#define Max 8

void dfs(int &n) {
  if (n == 0) return;
  int i;
  i = n % Max;
  n /= Max;
  dfs(n);
  printf("%d", i);
}

int main() {
  int num;
  scanf("%d", &num);
  if (num == 0) {
    printf("0");
  }
  
  dfs(num);
  return 0;
}