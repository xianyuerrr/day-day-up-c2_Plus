from math import comb, perm
from typing import List


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        dic = dict()
        n = len(nums)
        base = perm(2, 2) * perm(2, 2) * perm(2, 2)
        for i in range(n):
            for j in range(i+1, n):
                val = nums[i] * nums[j]
                dic[val] = dic[val] + 1 if (val in dic) else 1
        res = 0
        for key, val in dic.items():
            res += base * comb(val, 2)
        return res