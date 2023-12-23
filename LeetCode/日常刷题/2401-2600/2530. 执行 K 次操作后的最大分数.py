import heapq
from typing import List


class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        res = 0
        nums = [-val for val in nums]
        heapq.heapify(nums)
        while k:
            k -= 1
            val = heapq.heappop(nums)
            res -= val
            heapq.heappush(nums, val // 3)
        return res