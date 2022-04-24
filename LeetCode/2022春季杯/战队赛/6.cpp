#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, b) for (int i=a; i < (b); i++)
#define trav(a, x) for (auto& a : x)

typedef long long ll;

int main() {
    
    return 0;
}


//  Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	const int inf=1134567890;
	int sum[100010],ans,d,tot,mi[100010],cnt[100010];
	int getdep(TreeNode* x,int dep)
	{
		int d=dep;
		if (x->left) d=max(d,getdep(x->left,dep+1));
		if (x->right) 
		{
			int dd=getdep(x->right,dep+1);
			if (dd>d) swap(x->left,x->right),d=dd;
		}
		return d;
	}
	void getsum(TreeNode* x,int dep)
	{
		sum[dep]+=(x->val),cnt[dep]++;
		if (x->left) getsum(x->left,dep+1);
		if (x->right) getsum(x->right,dep+1);
		if (!(x->left)&&!(x->right)) mi[dep]=min(mi[dep],x->val);
	}
	int gnode(){t[++tot]=(node){0,0,0}; return tot;}
	struct node{int ls,rs,val;}t[5000010];
	void add(int i,int l,int r,int x,int v)
	{
		if (l==r) {t[i].val+=v; return;}
		int mid=(l+r)>>1;
		if (x<=mid)
		{
			if (!t[i].ls) t[i].ls=gnode();
			add(t[i].ls,l,mid,x,v);
		} else
		{
			if (!t[i].rs) t[i].rs=gnode();
			add(t[i].rs,mid+1,r,x,v);
		}
		t[i].val=max(t[t[i].ls].val,t[t[i].rs].val);
	}
	int query(int i,int l,int r,int x)
	{
        if (x>r) return -inf;
		if (l==r) return t[i].val;
		int mid=(l+r)>>1;
		if (x<=mid) return query(t[i].ls,l,mid,x);
		else return query(t[i].rs,mid+1,r,x);
	}
	pair<int,int> dfs(TreeNode* x,int dep,int vv)
	{
		int dd=0,Cnt=0;
		if (x->left) dd++;
		if (x->right) dd++;
		if (!dd) 
		{
			int rt=gnode();
			if (dep) add(rt,0,d,dep,sum[dep-1]+1ll*(x->val)-vv);
			if (!(dep==d-1&&cnt[d-1]==1)) add(rt,0,d,dep+1,sum[dep]-(x->val));
			return make_pair(rt,dep==d-1);
		}
		if (dd==1)
		{
			pair<int,int> rt;
			if (x->left) rt=dfs(x->left,dep+1,x->val);
			else rt=dfs(x->right,dep+1,x->val);
			ans=max(ans,t[rt.first].val);
			if (dep) add(rt.first,0,d,dep,sum[dep-1]+1ll*(x->val)-vv);
			return rt;
		}
		pair<int,int> rt1=dfs(x->left,dep+1,x->val),rt2=dfs(x->right,dep+1,x->val);
		for (int i=dep+1,la=x->val; i<=d; i++)
		{
			int t=query(rt2.first,0,d,i);
			if (t==-inf) break;
            t=t-1ll*sum[i-1]+la;
			add(rt1.first,0,d,i,t-(i==dep+1?0:la));
			la=t;
		}
		if (rt1.second&&rt2.second&&rt1.second+rt2.second==cnt[d-1]) 
			add(rt1.first,0,d,d,-inf-query(rt1.first,0,d,d));
		if (dep) add(rt1.first,0,d,dep,sum[dep-1]+1ll*(x->val)-vv);
		return make_pair(rt1.first,rt1.second+rt2.second);
	}
    int getMaxLayerSum(TreeNode* root) {
    	t[0].val=-inf,t[0].ls=t[0].rs=tot=0;
		d=getdep(root,0),ans=-inf;
		for (int i=0; i<=d; i++) sum[i]=0,mi[i]=0,cnt[i]=0;
		getsum(root,0);
		for (int i=0; i<=d; i++) ans=max(ans,sum[i]-(cnt[i]!=1?mi[i]:0));
		d++,dfs(root,0,0);
		return ans;
    }
};