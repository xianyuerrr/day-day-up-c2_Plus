#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        priority_queue<double> pq;
        int n = dist.size(), res=0;
        double cost=0, cost_sum=0;
        
        for (int i=0; i < n; i++) {
            cost = (double)dist[i] / speed;
            if (i != n-1) {
                pq.push(ceil(cost) - cost);
                cost_sum += ceil(cost);
            } else {
                cost_sum += cost;
            }
        }
        while (!pq.empty() && cost_sum > hoursBefore) {
            cout<<cost_sum<<','<<hoursBefore<<endl;
            cost_sum -= pq.top();
            pq.pop();
            res++;
        }
        if (cost_sum > hoursBefore) {
            return -1;
        }
        return res;
    }
};