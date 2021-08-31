from math import floor
from heapq import heapify, heappop, heappush
class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        # heapq是最小堆
        q = []
        for i in piles:
            heappush(q, -i)
        res = sum(piles)
        while k:
            k -= 1
            max_pile = -heappop(q)
            new_pile = max_pile - floor(max_pile / 2)
            res -= max_pile - new_pile
            heappush(q, -new_pile)
        return res
