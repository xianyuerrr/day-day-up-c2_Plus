#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l, r, m;
        l = 0;
        r = nums.size()-1;
        // 方法二
        // while (l < r) {
        //     m = l + (r - l >> 1);
        //     if (nums[m] > nums[r]) {l = m + 1;}
        //     else if (nums[m] < nums[r]) {r = m;}
        //     else {r--;}
        // }
        // 方法一
        while (r>0 && nums[r] == nums[0]) r--;
        while (l < r) {
            m = l + (r - l >> 1);
            if (nums[m] > nums[r]) {l = m + 1;}
            else if (nums[m] <= nums[r]) {r = m;}
        }
        return nums[l];

    }
};