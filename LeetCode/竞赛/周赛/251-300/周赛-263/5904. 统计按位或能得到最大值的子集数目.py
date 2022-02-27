from typing import List
class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        res = 0
        target = 0
        n= len(nums)
        # 全部元素的与肯定是最大值
        for i in nums:
            target |= i
        
        # 数位枚举子集
        for i in range(pow(2, n)):
            # 求子集的并
            ans = 0
            for j in range(n):
                if i >> j & 1:
                    ans |= nums[j]
            if ans == target:
                res += 1
        return res
