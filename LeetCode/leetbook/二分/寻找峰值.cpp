    #include <bits/stdc++.h>
    using namespace std;

    class Solution {
    public:
        int findPeakElement(vector<int>& nums) {
            int l, r, m;
            nums.insert(nums.begin(), INT_MIN);
            nums.push_back(INT_MAX);
            l = 1;
            r = nums.size() - 2;
            while (l < r) {
                m = l + (r-l >> 1);
                if (nums[m] < nums[m+1]) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
            // while (l < r) {
            //     m = l + (r-l >> 1) + 1;
            //     if (nums[m] <= nums[m-1]) {
            //         r = m-1;
            //     } else {
            //         l = m;
            //     }
            // }
            return l-1;
        }
    };