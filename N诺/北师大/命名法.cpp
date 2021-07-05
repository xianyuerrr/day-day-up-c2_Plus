#include <bits/stdc++.h>

using namespace std;

int main() {
    string name;
    while (cin>>name) {
        int n = name.size();
        vector<char> new_name;
        for (char c : name) {
            if ('A' <= c && c <= 'Z') {
                new_name.push_back('_');
                new_name.push_back(c+32);            
            } else{
                new_name.push_back(c);
            }
        }
        for (char c : new_name) {
            cout<<c;
        }
        cout<<endl;
    }
    return 0;
}
