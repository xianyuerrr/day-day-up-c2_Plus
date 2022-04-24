#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, b) for (int i=a; i < (b); i++)
#define trav(a, x) for (auto& a : x)

typedef long long ll;


class Solution {
public:
	static const int maxn=(1e5)+10;
	int tot;
	struct node {
		int t,x,y;
	} d[maxn];
	static bool cmp(node A,node B) { return A.t<B.t; }
	int dp[maxn],pre[maxn];
    int getMaximumNumber(vector<vector<int>>& V) {
    	tot=0;
		for (vector<int> &A : V) d[++tot]=(node){A[0],A[1],A[2]};
		sort(d+1,d+tot+1,cmp);
		d[0]=(node){0,1,1};
		dp[0]=pre[0]=0;
		for (int i=1;i<=tot;i++) {
			dp[i]=-1e9;
			for (int j=i-1;j>=0;j--) {
				if (d[j].t>=d[i].t-7) {
					if (abs(d[i].x-d[j].x)+abs(d[i].y-d[j].y)<=d[i].t-d[j].t) dp[i]=max(dp[i],dp[j]+1);
				} else {
					dp[i]=max(dp[i],pre[j]+1);
					break;
				}
			}
			pre[i]=max(pre[i-1],dp[i]);
		}
		return pre[tot];
    }
};