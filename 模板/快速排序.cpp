#include <bits/stdc++.h>
using namespace std;

int quick_sort(vector<int> &nums, int left, int right) {
    if (left >= right) return 0;

    int target_idx = rand() % (right - left + 1) + left;
    swap(nums[left], nums[target_idx]);
    target_idx = left;
    for (int i = left+1; i <= right; i++) {
        if (nums[i] <= nums[left]) {
            swap(nums[++target_idx], nums[i]);
        }
    }
    swap(nums[target_idx], nums[left]);
    quick_sort(nums, left, target_idx-1);
    quick_sort(nums, target_idx+1, right);
    return 0;
}