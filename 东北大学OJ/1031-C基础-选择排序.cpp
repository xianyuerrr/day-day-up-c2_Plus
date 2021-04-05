#include <bits/stdc++.h>

using namespace std;

int main() {
    // vector + sort
    vector<int> vec;
    int ans;
    for (int idx{0}; idx<10; idx++) {
        scanf("%d", &ans);
        vec.push_back(ans);
    }
    sort(vec.begin(), vec.end());
    for (vector<int>::iterator it{vec.begin()}; it!=vec.end(); it++) {
        printf("%d\n", *it);
    }
    // 优先级队列方法
    // priority_queue<int, vector<int>, greater<int>> q;
    // int ans;
    // for (int idx{0}; idx < 10; idx++) {
    //     scanf("%d", &ans);
    //     q.push(ans);
    // }
    // while(!q.empty()) {
    //     printf("%d\n", q.top());
    //     q.pop();
    // }
    return 0;
}
