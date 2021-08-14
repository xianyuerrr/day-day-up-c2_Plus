#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int sum{0};
        vector<int> now(n), best(n), greater(n);
        for (int idx{0}; idx < n; idx++) {
            now[idx] = abs(nums1[idx]-nums2[idx]);
            sum += now[idx];

            best[idx] = abs(nums1[idx] - nums2[idx]);
        }
        set<int> nums1_set(nums1.begin(), nums1.end());

        int max_add{0}, max_idx{0};
        for (int idx{0}; idx < n; idx++) {
            for (set<int>::iterator it = nums1_set.begin(); it != nums1_set.end(); it++) {
                best[idx] = min(best[idx], abs(nums2[idx] - *it));
            }
            greater[idx] = now[idx] - best[idx];
            if (max_add < greater[idx]) {
                max_add = greater[idx];
                max_idx = idx;
            }
        }
        return sum-greater[max_idx];        
    }
};