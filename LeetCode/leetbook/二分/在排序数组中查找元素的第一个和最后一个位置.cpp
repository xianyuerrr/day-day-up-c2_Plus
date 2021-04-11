#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int left_binary_search(vector<int> &nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    int right_binary_search(vector<int> &nums, int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = left + (right - left >> 1) + 1;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.empty()) return {-1, -1};
        int l, r;
        l = 0;
        r = nums.size()-1;
        int x1 = left_binary_search(nums, l, r, target);
        int x2 = right_binary_search(nums, l, r, target);
        return {x1, x2};
    }
};


class Solution {
public:
    vector<int> binary_search(vector<int> &nums, int left, int right, int target, int flag) {
        // flag 为一个标志位
        // flag == 0, 还没有找到第一个 target
        // flag == -1, 搜索左边界
        // flag == 1, 搜索右边界
        int mid, x1, x2;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                // 由于边界收缩的设置，不会出现 mid == right 的情况， 但是会出现 left == mid 的情况，这会导致区间无法缩减到长度为一
                // 如果是 mid = left + (right - left >> 1) + 1, left = mid, right = mid-1
                // 就会出现上述情况了
                if (flag != 1) {
                    x1 = mid == right ?  : binary_search(nums, left, mid, target, -1)[0];
                } else {
                    x1 = left;
                }
                if (flag != -1) {
                    x2 = mid == left ? nums[right] == target ? right : mid : binary_search(nums, mid, right, target, 1)[1];
                } else {
                    x2 = right;
                }
                return {x1, x2};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return {left, right};
        } else {
            return {-1, -1};
        }
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.empty()) return {-1, -1};
        return binary_search(nums, 0, nums.size()-1, target, 0);
    }
};

int main() {
    vector<int> v {5,7,7,8,8,10};
    int target {8};

    Solution s = Solution();
    vector<int> res = s.searchRange(v, target);
    for (int i : res) {
        printf("%d, ", i);
    }
}