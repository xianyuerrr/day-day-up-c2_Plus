#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    bool squareIsWhite(string coordinates) {
        int x = coordinates[0] - 'a' + 1;
        int y = coordinates[1] - '0';
        return (x+y) % 2 == 1;
    }
    bool squareIsWhite(string a) {
        return (a[0] % 2) != (a[1] % 2);
    }
};
