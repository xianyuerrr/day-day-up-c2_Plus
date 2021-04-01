#include <bits/stdc++.h>
using namespace std;

int dfs(int n, int a, int b, vector<int> &v) {
  // 函数内改变 vector 需要使用引用传递 !!!
  if (n == 1) {
    return a;
  } else if (n == 2) {
    return b;
  }
  // 记忆化
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
  scanf("%d", &num);
  vector<int> a(num), b(num), c(num);
  int idx {-1};
  while (idx++ < num-1) {
    scanf("%d%d%d", &a[idx], &b[idx], &c[idx]);
  }
  idx = -1;
  while (idx++ < num-1) {
      vector<int> v(c[idx], -1);
      printf("%d", dfs(c[idx], a[idx], b[idx], v));
      if (num > 0) printf("\n");
  }
  return 0;
}