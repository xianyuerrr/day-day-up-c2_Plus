import heapq
from typing import *


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        heap = [-pile for pile in piles]
        heapq.heapify(heap)
        while k:
            k -= 1
            top = - heapq.heappop(heap)
            rm = top // 2
            heapq.heappush(heap, - top + rm)
        return - sum(heap)