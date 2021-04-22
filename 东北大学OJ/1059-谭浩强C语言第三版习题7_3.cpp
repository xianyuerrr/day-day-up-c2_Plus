#include <bits/stdc++.h>

using namespace std;

int main() {
    int ans;
    int count = 9;
    priority_queue<int, vector<int>, greater<int> > q;
    for (int idx = 0; idx < count+1; idx++) {
        scanf("%d", &ans);
        q.push(ans);
    }
    while (!q.empty()) {
        printf("%d\n", q.top());
        q.pop();
    }
    return 0;
}
