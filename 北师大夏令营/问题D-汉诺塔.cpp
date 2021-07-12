#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

// int dfs(ll n)
ll qpow(ll a, ll b, ll q) {
    ll ret=1;
    while (b) {
        if (b & 1) {ret = ret * a % q;}
        a = a * a % q;
        b >>= 1;
    }
    return ret;
}

ll hanoi(ll n, ll q) {
    if (n == 1) {return 2;}    
    return (hanoi(n-1, q) * 3 + 2) % q;
}

int main() {
    ll n, q;
    cin >> n >> q;
    // if (n <= 0 || q <= 0) {cout << 0;}
    cout << (qpow(3, n, q) - 1) % q << endl;
    return 0;
}
