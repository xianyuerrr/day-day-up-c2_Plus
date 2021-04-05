import heapq
class Solution:
    def magicTower(self, nums: List[int]) -> int:
        ssum = sum(nums)
        if ssum < 0:
            return -1
        ssum = 0
        hq = []
        res = 0
        for i in nums:
            ssum += i
            if i < 0:
                heapq.heappush(hq, i)
                if ssum < 0:
                    ssum -= heapq.heappop(hq)
                    res += 1
        return res
                