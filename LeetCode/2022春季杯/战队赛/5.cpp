#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, b) for (int i=a; i < (b); i++)
#define trav(a, x) for (auto& a : x)

typedef long long ll;

int main() {
    
    return 0;
}


class Solution {
public:
    
int n;
int ch[300005][2],fa[300005],sz[300005],rt,nd;
long long val[300005],tg[300005];

void pushup(int k){
	sz[k]=sz[ch[k][0]]+sz[ch[k][1]]+1;
}
void add(int k,long long v){
	val[k]+=v;
	tg[k]+=v;
}
void pushdown(int k){
	if (tg[k]){
		if (ch[k][0]) add(ch[k][0],tg[k]);
		if (ch[k][1]) add(ch[k][1],tg[k]);
		tg[k]=0;
	}
}
void Down(int k){
	if (fa[k]) Down(fa[k]);
	pushdown(k);
}
void rotate(int x){
	int y=fa[x],z=fa[y];
	int l=(ch[y][1]==x),r=l^1;
	if (z) ch[z][ch[z][1]==y]=x;
	fa[x]=z; fa[y]=x; fa[ch[x][r]]=y;
	ch[y][l]=ch[x][r]; ch[x][r]=y;
	pushup(y); pushup(x);
}
void splay(int x){
	Down(x);
	for (;fa[x];rotate(x)){
		int y=fa[x],z=fa[y];
		if (z) rotate((ch[y][0]==x)^(ch[z][0]==y)?x:y);
	}
	rt=x;
}

void insert(int &k,int f,int v){
	if (!k){
		k=++nd; val[k]=v; fa[k]=f;
		pushup(k);
		return;
	}
	pushdown(k);
	if (v<=val[k]) insert(ch[k][0],k,v);
	else insert(ch[k][1],k,v);
	pushup(k);
}
int findrk(int k,int p){
	pushdown(k);
	if (sz[ch[k][0]]+1==p) return k;
	if (sz[ch[k][0]]>=p) return findrk(ch[k][0],p);
	return findrk(ch[k][1],p-sz[ch[k][0]]-1);
}
int findl(int k){
	for (;ch[k][0];k=ch[k][0]);
	return k;
}
void insert(int v){
	if (!rt) rt=++nd,val[rt]=v,pushup(rt);
	else insert(rt,0,v),splay(nd);	
}
    long long buildBridge(int num, vector<vector<int>>& wood) {
n=wood.size();
	insert(wood[0][0]);
	insert(wood[0][0]);
	long long ans=0;
	for (int i=1;i<n;i++){
		int p=findrk(rt,i);
		int dl=wood[i][1]-wood[i][0];
		int dr=wood[i-1][1]-wood[i-1][0];
		splay(p); add(p,-dl); add(ch[p][1],dl+dr);
		int q=findl(ch[p][1]); splay(q);
		insert(wood[i][0]);
		insert(wood[i][0]);
		if (val[p]<=wood[i][0]&&wood[i][0]<=val[q]);
		else if (wood[i][0]<val[p]) ans-=wood[i][0]-val[p];
		else ans-=val[q]-wood[i][0];
	}
        return ans;
    }
};