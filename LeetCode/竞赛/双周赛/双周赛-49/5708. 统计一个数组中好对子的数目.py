import collections
from functools import lru_cache
class Solution:
    def rev(self, num: int) -> int:
        rev = 0
        while num != 0:
            rev = rev * 10 + num % 10
            num //= 10
        return rev
    @lru_cache
    def zuhe(self, num:int) -> int:
        @lru_cache
        def jiecheng(i: int) -> int:
            if i == 1 or i == 0:
                return 1
            return i * jiecheng(i-1)
        return jiecheng(num) / (jiecheng(2) * jiecheng(num-2))
    def countNicePairs(self, nums: List[int]) -> int:
        nums_rev = list(map(self.rev, nums))
        n = len(nums)
        r = [nums[i] - nums_rev[i] for i in range(n)]
        res = 0
        r_count = collections.Counter(r)
        for k, v in r_count.items():
            if v > 1:
                res += self.zuhe(v)

        # for i in range(n):
        #     for j in range(i+1, n):
        #         if r[i] == r[j]:
        #             res += 1
        return int(res % (pow(10, 9) + 7))