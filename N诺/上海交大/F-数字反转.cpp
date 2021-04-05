#include <iostream>
using namespace std;
int reverse(int n)
{
    int res=0;
    while(n>0)
        {
            res=n%10+res*10;
            n /=10;
        }
    return res;
    
} 
int main()
{
    int x,y;
    while(cin>>x>>y)
    {
    
        int res1;
        res1=reverse(x)+reverse(y);
        if(res1==reverse(x+y)) 
        {
            cout<<x+y<<endl;
        }
        else
            cout<<"NO"<<endl;       
    }
    return 0;    
} 
// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//     int x, y;
//     int sum_nums;
//     int shuliangji{10};
//     while (scanf("%d%d", &x, &y) != EOF) {
//         sum_nums = x + y;
//         if (x > y) swap(x, y);
//         while (y / shuliangji != 0) {
//             shuliangji *= 10;
//         }
//         if (sum_nums >= shuliangji) {
//             printf("NO\n");
//         } else {
//             printf("%d\n", sum_nums);
//         }
//     }
//     return 0;
// }
