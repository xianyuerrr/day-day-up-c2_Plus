#include <bits/stdc++.h>

using namespace std;

int n;
unsigned int s;
unsigned int getNext() {
    s=s^(s<<13);
    s=s^(s>>17);
    s=s^(s<<5);
    return s;
}

unsigned int qgcd(unsigned int x, unsigned int y) {
    if (x > y) {return qgcd(y, x);}
    if (x == 0) {return y;}
    if (y % x == 0) {return x;}
    return qgcd(y%x, x);
}

unsigned int dfs(int *a, unsigned int have, unsigned int idx, unsigned int ans, int n) {
    if (idx == n) {return have > 1 ? have * ans : 0;}
    unsigned int i = dfs(a, have, idx+1, ans, n);
    unsigned int j = dfs(a, have+1, idx+1, qgcd(ans, a[idx]), n);
    return i > j ? i : j;
}

int main() {
    cin>>n>>s;
    int a[n];
    for(int i=0;i<n;++i){
        a[i]=getNext()%2000000+1;
    }
    int m = *min_element(a, a+n) + 1;

    int g[m];
    fill(g, g+m, 0);
    int res = 0;
    for (int i = 1; i < 20; i++) {
        for (int j : a) {
            if (j % i == 0) {
                g[i]++;
            }
        }
        if (g[i] < 2) {continue;}
        res = res > g[i]*i ? res : g[i]*i;
    }
    cout << res;
}