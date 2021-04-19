#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int quick_sort(vector<int> &nums, int l, int r) {
        // 随机选取
        int rand_idx = rand() % (r - l + 1) + l;

        swap(nums[l], nums[rand_idx]);
        int target = nums[l];
        int i = l;
        for (int idx{l+1}; idx <= r; idx++) {
            if (nums[idx] <= target) {
                swap(nums[++i], nums[idx]);
            }
        }
        // nums[i] = target;
        swap(nums[l], nums[i]);
        return i;
    }
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        // 快速排序，平均 O(n)
        int l{0}, r{(int) arr.size()-1};
        int idx;
        while (l < r) {
            idx = quick_sort(arr, l, r);
            if (idx == k-1 || idx == k) {
                break;
            } else if (idx < k-1) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        // return arr;
        vector<int> vec;
        for (int i = 0; i < k; ++i) {
            vec.push_back(arr[i]);
        }
        return vec;
    }
};

