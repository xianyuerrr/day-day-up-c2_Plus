#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int storeWater(vector<int>& bucket, vector<int>& vat) {
        int ans = 0;
        priority_queue<pair<int, int>> q;
        for(int i = 0; i < bucket.size(); ++i) {
            if(bucket[i] == 0 && vat[i] != 0) {
                bucket[i] = 1;
                ++ans;
            }
            if(vat[i] != 0) {
                q.emplace((vat[i] - 1) / bucket[i] + 1, i);
            }
        }
        int i, cur_ans = q.size() ? q.top().first : 0;
        while(!q.empty() && q.top().first > 1) {
            int updates = 0, new_times = INT_MAX, saved_times = INT_MAX;
            cur_ans = q.top().first;
            while(q.top().first == cur_ans && updates < q.size()) {
                i = q.top().second;
                ++updates;
                ++bucket[i];
                q.pop();
                new_times = (vat[i] - 1) / bucket[i] + 1;
                saved_times = min(saved_times, cur_ans - new_times);
                q.emplace(new_times, i);
            }
            if(saved_times >= updates && saved_times != INT_MAX) {
                ans += updates;
            }else {
                break;
            }
        }
        return ans + cur_ans;
    }
};