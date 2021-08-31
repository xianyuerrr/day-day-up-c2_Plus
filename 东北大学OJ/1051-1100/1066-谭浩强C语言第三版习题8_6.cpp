#include <bits/stdc++.h>

using namespace std;

int main() {
    string s1;
    string s2;
    cin>>s1;
    cin>>s2;

    int l1 = s1.size();
    int l2 = s2.size();
    
    char res[l1+l2];
    for (int i = 0; i < l1+l2; i++) {
        if (i < l1) res[i] = s1[i];
        else res[i] = s2[i-l1];
    }
    cout<<res;
    return 0;
}
