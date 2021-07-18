#include <bits/stdc++.h>

using namespace std;

int main() {
    int row, lis[26];
    string s;
    map<char, int> mp;

    cin >> row;

    while (row--) {
        // for (int i=0; i<26; i++) {
        //     lis[i] = 0;
        // }
        cin >> s;
        for (int i=0; i < s.size(); i++) {
            mp[s[i]] += 1;
        }
        for (map<char, int> :: iterator it = mp.begin(); it != mp.end();it++) {
            cout << it -> first << ' ' << it -> second << endl;
        }
        mp.erase(mp.begin(),mp.end());
    }

    return 0;
}
