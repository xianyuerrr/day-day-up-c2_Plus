#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l, r, m;
        l = 0;
        r = nums.size()-1;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] < nums[r]) {
                r= m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            }
        }
        return nums[l];
    }
};