#include <bits/stdc++.h>

using namespace std;

int gcd(int x, int y) {
    if (y % x == 0) return x;
    if (x > y) return gcd(y, x);
    return gcd(y % x, x);
}

int main() {
    int count;
    cin>>count;
    
    int min_num = INT_MAX, max_num = INT_MIN;
    int g;
    int ans;
    
    while (count-- > 0) {
        cin>>ans;
        min_num = min_num < ans ? min_num : ans;
        max_num = max_num > ans ? max_num : ans;
    }
    g = gcd(max_num, min_num);
    cout<<min_num<<' '<<max_num<<' '<< g;
    return 0;
}
