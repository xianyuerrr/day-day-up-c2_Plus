#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        quick_sort(nums, 0, nums.size()-1);
        return nums;
    }

    int quick_sort(vector<int>& nums, int left, int right) {
        if (left >= right) return 0;
        int pivotpos = partition(nums, left, right);

        quick_sort(nums, left, pivotpos-1);
        quick_sort(nums, pivotpos+1, right);
        return 0;
    }

    int partition(vector<int>& nums, int left, int right) {
        int target_idx = rand() % (right - left + 1) + left;
        swap(nums[left], nums[target_idx]);
        target_idx = left;
        // for (int i = left+1; i <= right; i++) {
        //     if (nums[i] <= nums[left]) {
        //         swap(nums[++target_idx], nums[i]);
        //     }
        // }
        for (int i = left+1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums[++target_idx], nums[i]);
            }
        }
        swap(nums[target_idx], nums[left]);
        return target_idx;
    }
};