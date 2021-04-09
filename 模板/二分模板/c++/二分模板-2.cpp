#include <bits/stdc++.h>
using namespace std;

// 用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件
int binarySearch(vector<int>& nums, int target){
  if(nums.size() == 0)
    return -1;

  int left = 0, right = nums.size();

  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left >> 1);
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }
  // Post-processing:
  // End Condition: left == right
  if(left != nums.size() && nums[left] == target) return left;
  return -1;
}