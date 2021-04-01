#include <bits/stdc++.h>
using namespace std;

int dfs(int n, int a, int b, vector<int> v) {
  if (n == 1) {
    return a;
  } else if (n == 2) {
    return b;
  }
  if (v[n-1] != -1) return v[n-1];
  int res;
  if (n % 2 == 0) {
    res = dfs(n-1, a, b, v) + dfs(n-2, a, b, v) + dfs(n-3, a, b, v);
  } else{
    res = dfs(n-1, a, b, v) + dfs(n-2, a, b, v);
  }
  v[n-1] = res;
  return res;
}
int main() {
  int num;
  int a, b, c;
  scanf("%d", &num);
  while (num-- > 0) {
    scanf("%d%d%d", &a, &b, &c);
    vector<int> v(c, -1);
    printf("%d", dfs(c, a, b, v));
    if (num > 0) printf("\n");
  }
  return 0;
}