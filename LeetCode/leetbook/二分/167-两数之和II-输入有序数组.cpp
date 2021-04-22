#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    // 数组参数的 const 和 & 很重要，不然会调用拷贝构造函数
    int binary_search(const vector<int> &nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> res;
        int n = numbers.size();
        int ans;
        for (int i = 0; i < n-1; i++) {
            if (!res.empty() && res[res.size()-1]-1  <= i) break;
            ans = binary_search(numbers, i+1, res.empty() ? n - 1 : res[res.size()-1]-1, target-numbers[i]);
            if (ans != -1) {
                res.push_back(i+1);
                res.push_back(ans+1);
            }
        }
        return res;
    }
};