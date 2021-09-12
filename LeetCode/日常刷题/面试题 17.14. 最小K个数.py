import random
from typing import *
from heapq import heapify, heapreplace
class Solution:
    def qsortAtOnce(self, arr, l, r):
        random_idx = random.randint(l, r)
        arr[l], arr[random_idx] = arr[random_idx], arr[l]
        left = l+1
        # if idx < left, num <= val
        # elif idx >= left, num > val
        # elif idx == left-1, num == val
        for right in range(l+1, r+1):
            if arr[right] <= arr[l]:
                arr[left], arr[right] = arr[right], arr[left]
                left += 1

        arr[l], arr[left-1] = arr[left-1], arr[l]
        return left-1

    def smallestK(self, arr: List[int], k: int) -> List[int]:
        # 快排
        l = 0
        r = len(arr)-1
        while l < r:
            mid = self.qsortAtOnce(arr, l, r)
            if mid == k or mid+1 == k:
                l = r = mid
            elif mid < k:
                l = mid+1
            else:
                r = mid-1
        return arr[:k]

        
s = Solution()
arr = [1,3,5,7,2,4,6,8]; k = 4
print(s.smallestK(arr, k))