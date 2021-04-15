#include <bits/stdc++.h>

using namespace std;

int main() {
    string a, b;
    int len_a, len_b, ans{0};
    vector<int> v;
    while (cin>>a >> b) {
        len_a = a.size()-1;
        len_b = b.size()-1;
        while (len_a >= 0 and len_b >= 0) {
            ans += a[len_a] + b[len_b] - 2 * '0';
            v.push_back(ans % 10);
            ans /= 10;
            len_a--;
            len_b--;
        }
        while (len_b >= 0) {
            ans += b[len_b] - '0';
            v.push_back(ans % 10);
            ans /= 10;
            len_b--;
        }
        while (len_a >= 0) {
            ans += a[len_a] - '0';
            v.push_back(ans % 10);
            ans /= 10;
            len_a--;
        }
        if (ans != 0) {
            v.push_back(ans);
        }
        ans = 0;
        for (int i=v.size()-1; i >= 0; i--) {
            cout<<v[i];
        }
        v.clear();

        // while (!v.empty()) {
        //     cout<<*(v.end()-1);
        //     v.pop_back();
        // }
        
        cout<<endl;
    }
    
    return 0;
}
