#include <bits/stdc++.h>
using namespace std;
int binarySearch(vector<int>& nums, int target){
  if(nums.size() == 0)
    return -1;

  int left = 0, right = nums.size() - 1;
  // 最基础的形式
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left >> 1);
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}