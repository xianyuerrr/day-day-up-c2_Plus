#include <bits/stdc++.h>

using namespace std;

// int dfs(long long n)
long long qpow(long long a, long long b, long long q) {
    long long ret=1;
    while (b) {
        if (b & 1) {ret = ret * a % q;}
        a = a * a % q;
        b >>= 1;
    }
    return ret;
}

long long hanoi(long long n, long long q) {
    if (n == 1) {return 2;}    
    return (hanoi(n-1, q) * 3 + 2) % q;
}

int main() {
    long long n, q;
    cin >> n >> q;
    cout << (hanoi(3, n, q) - 1) % q << endl;
    return 0;
}
