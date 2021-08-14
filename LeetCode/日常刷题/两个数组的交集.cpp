    #include <bits/stdc++.h>
    using namespace std;

    class Solution {
    public:
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
        vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
            int m = nums1.size(), n = nums2.size();
            quick_sort(nums1, 0, m-1);
            quick_sort(nums2, 0, n-1);

            int idx1 = 0, idx2 = 0;
            vector<int> res;

            while (idx1 < m && idx2 < n) {
                if (nums1[idx1] == nums2[idx2]) {
                    res.push_back(nums1[idx1]);
                    idx1++;
                    idx2++;
                    // 避免 res 出现重复值
                    // 如果注释这部分，
                    // 每个元素出现的次数，应与元素在两个数组中出现次数的 最小值 一致
                    while (idx1 < m && nums1[idx1-1] == nums1[idx1]) {
                        idx1++;
                    }
                    while (idx2 < n && nums2[idx2-1] == nums2[idx2]) {
                        idx2++;
                    }
                } else if (nums1[idx1] > nums2[idx2]) {
                    idx2++;
                } else if (nums1[idx1] < nums2[idx2]) {
                    idx1++;
                }
            }
            return res;
        }
    };