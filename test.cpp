#include <bits/stdc++.h>
using namespace std;

int main() {
  int a[] = {1,2,3,4,5,6};
  int *p = a;
  p += 3;
  cout<<*++p;
	// int a[3][3];
	// fill(a[0], a[2]+3, 314);
	// fill(a[0], a[0]+3*3, 314);	
	// for (int i=0; i < 3; i++) {
	// 	for (int j=0; j < 3; j++) {
	// 		// 不要使用 printf，有很大问题
  //       	cout<<a[i][j]<<endl;;
	// 	}
	// }
  // int a{0}, b{0}, row;
  // int ans, count{0};
  // cin >> row;
  // scanf("%d", &row);

  // while (row-- > 0) {
  //   scanf("%d", &ans);
  //   for (int i{1}; i<=sqrt(ans); i++) {
  //     if (ans%i == 0) {
  //       count += 2;
  //       if (i == sqrt(ans)) count--;
  //     }
  //   }
  //   printf("%d\n", count);
  //   count = 0;
  // }
  // cout << a*b << endl; 
  return 0;
}