
#include<bits/stdc++.h>
using namespace std;


int main(){
	int dp[1000005];
	memset(dp,0,sizeof(dp));
	dp[0]=1;dp[1]=1;
	for(int i=2;i<=100000;i++){
		if(i%2){
			dp[i]=dp[i-1];
		}
		else{
			dp[i]=(dp[i-2]+dp[i/2])%1000000000;
		}
	}
	int n;
	while(scanf("%d",&n)!=EOF){
		printf("%d\n",dp[n]);
	}
	return 0;
}

// #include <bits/stdc++.h>
// using namespace std;
// int a[1000001];
// int main(){

//     a[1] = 1;
//     a[2] = 2;
//     for(int i = 3;i<1000001;i++){
//         if(i%2 == 0){a[i] = (a[i-1] + a[i/2])%1000000000; }
//         else{a[i] = a[i-1]%1000000000;}
//     }
//     int n;
//     while(cin>>n){
//         cout<<a[n]<<endl;
//     }

//     return 0;
// }