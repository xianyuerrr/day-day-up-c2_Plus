#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int magicTower(vector<int>& nums) {
        long long ssum{0};
        int res{0};
        for (int i : nums) ssum += i;
        if (ssum < 0) return -1;
        ssum = 0;
        priority_queue<int> pq;
        for (int i : nums) {
            ssum += i;
            if (i < 0) {
                pq.push(i);
                if (ssum < 0) {
                    ssum -= pq.top();
                    pq.pop();
                    res++;
                }
            }
        }
        return res;
    }
};