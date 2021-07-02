#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

int main() {
    int row;
    
    cin>>row;
    vector<string> str_lis(row);
    string s;
    while (row-- > 0) {
        cin>>str_lis[row];
    }
    cin>>s;

    unordered_set<string> can_do;
    
}