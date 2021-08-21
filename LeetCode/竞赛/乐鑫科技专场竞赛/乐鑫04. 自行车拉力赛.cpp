#include <bits/stdc++.h>

using namespace std;

class Solution {
    using ll = long long;
public:
    int minSupplyTimes(int num, int initWater, vector<vector<int>>& s) {
        // 优先队列
        priority_queue<ll> q;
        
        // 为了保证最终能到目标站点，将该点视为一个水量为 0 的补给站
        s.push_back({num, 0});
        
        int n = s.size();
        // 当前水量 cur，上一个站点位置 pred，补水次数 ret
        ll cur = initWater, pred = 0, ret = 0;
        
        for(int i = 0; i < n; i++) {
            ll dist = s[i][0];
            ll water = s[i][1];
            
            cur -= (dist - pred);
            
            while(!q.empty() && cur < 0) {
                // 补水
                ll now = q.top();
                cur += now;
                ret++;
                q.pop();
            }
            // 水量仍为负：说明无法到达
            if(cur < 0) return -1;
            // 当前水量入队，并更新上一个站点位置
            q.push(water);
            pred = dist;
        }
        return ret;
    }
};
