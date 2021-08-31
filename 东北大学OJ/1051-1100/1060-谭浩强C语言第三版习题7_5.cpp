#include <bits/stdc++.h>

using namespace std;

int main() {
    int ans;
    int count = 10;
    stack<int> s;
    for (int idx = 0; idx < count; idx++) {
        scanf("%d", &ans);
        s.push(ans);
    }
    if (!s.empty()) {
        printf("%d", s.top());
        s.pop();
    }
    while (!s.empty()) {
        printf(" %d", s.top());
        s.pop();
    }
    return 0;
}
