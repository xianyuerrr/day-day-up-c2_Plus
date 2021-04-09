#include <vector>
using namespace std;

class Solution {
public:
    int BinarySearch(vector<int> &nums, int l, int r, int target) {
        int mid;
        while (l < r) {
            mid = l + (r-l >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    int search(vector<int>& nums, int target) {
        int l = 0, r = nums.size()-1, mid;
        // 二分查找最小值下标
        while (l < r) {
            mid = l + (r-l >> 1);
            if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        
        int x = BinarySearch(nums, 0, l-1, target);
        x = x != -1 ? x : BinarySearch(nums, l, nums.size()-1 , target);
        return x;
    }
};