#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // 双指针大法好
        int left{0};
        int can_have {1};
        for (int right{1}; right < nums.size(); right++) {
            if (nums[left] == nums[right]) {
                if (can_have == 1) {
                    can_have -= 2;
                } else {
                    continue;
                }
            }
            can_have = can_have == -1 ? 0 : 1;
            left++;
            swap(nums[left], nums[right]);
            // printf("%d, %d\n", left, right);
        }
        return left+1;
    }
};

int main() {
    Solution s;
    vector<int> v;
}