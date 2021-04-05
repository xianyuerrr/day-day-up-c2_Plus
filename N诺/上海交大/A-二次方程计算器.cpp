#include <bits/stdc++.h>

using namespace std;

int main() {
    // 这就是交大的题吗，爱了爱了
    // e.g.: x^2+x=3x+4
    int a{0}, b{0}, c{0};
    int ans{0};
    int signal{1};
    string s;
    getline(cin, s);
    for (int idx{0}; idx < s.size(); idx++) {
        char chr{s[idx]};
        // printf("%c, a: %d, b: %d, c: %d, ans: %d, signal:%d\n", chr, a, b, c, ans, signal);
        if (chr == '=') {
            signal = -signal;
        } else if (chr == '+') {
            c += ans != 0 ? ans * signal : 0;
        } else if (isdigit(chr)) {
            ans = ans * 10 + chr - '0';
        } else if (chr == 'x') {
            if (s.substr(idx, 3) == "x^2") {
                idx += 2;
                a += ans != 0 ? ans * signal : signal;
            } else {
                b += ans != 0 ? ans * signal : signal;
            }
            ans = 0;
        }
    }

    c += ans != 0 ? ans * signal : 0;

    double x1, x2;
    x1 = (b + sqrt(pow(b, 2) - 4*a*c)) / (-2*a);
    x2 = (b - sqrt(pow(b, 2) - 4*a*c)) / (-2*a);
    if (x1 > x2) swap(x1, x2);
    // printf("a: %d, b: %d, c: %d\n", a, b, c);
    printf("%.2lf %.2lf", x1, x2);
    return 0;
}
