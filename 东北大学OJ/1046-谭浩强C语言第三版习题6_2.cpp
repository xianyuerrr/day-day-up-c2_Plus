#include <bits/stdc++.h>

using namespace std;

int main() {
    string s;
    getline(cin, s);
    int count_a{0}, count_num{0}, count_space{0}, count_else{0};
    for (char c : s) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) count_a++;
        else if ('0' <= c && c <= '9') count_num++;
        else if (c == ' ') count_space++;
        else count_else++;
    }
    printf("%d %d %d %d", count_a, count_num, count_space, count_else);
    return 0;
}
