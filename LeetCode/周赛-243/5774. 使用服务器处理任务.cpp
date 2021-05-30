#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        vector<int> ans;
        int a, b, c;
        vector<int> p;
        priority_queue<vector<int>, vector<vector<int>>, greater<int> > pq;
        for (int i=0; i < servers.size(); i++) {
            vector<int> v{0, servers[i], i};
            pq.push(v);
        }
        int idx = 0;
        for (int time=1; ; time++) {
            if (idx == tasks.size()) break;
            p = pq.top();
            pq.pop();
            if (p[0] > time) {
                time = p[0];
            }
            ans.push_back(p[2]);
            p[0] += tasks[idx];
            pq.push(p);
            idx++;
        }
        return ans;
    }
};