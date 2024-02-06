from typing import List
import heapq


class Solution:
    def magicTower(self, nums: List[int]) -> int:
        res = 0
        hp = []
        ssum = 1
        delay = 0
        for i in nums:
            if i < 0:
                heapq.heappush(hp, i)
            ssum += i
            if ssum < 1:
                ssum -= hp[0]
                delay += hp[0]
                res += 1
                heapq.heappop(hp)
        return -1 if ssum + delay <= 0 else res