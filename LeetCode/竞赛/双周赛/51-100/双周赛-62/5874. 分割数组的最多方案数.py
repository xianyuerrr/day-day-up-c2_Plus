from typing import *
from collections import defaultdict
class Solution:
    def waysToPartition(self, nums: List[int], k: int) -> int:
        n = len(nums)
        preSum = [0] * n
        for i in range(n):
            preSum[i] = (preSum[i-1] if i != 0 else 0) + nums[i]
        print(preSum)
        # 计算不更改时的数目
        res = 0
        for i in range(1, n):
            # 就是使 preSum[i-1] 等于 总和的一半
            if preSum[i-1] == preSum[n-1] - preSum[i-1]:
                res += 1

        # 将哪个位置的元素改为 k
        l = defaultdict(int)
        r = defaultdict(int)
        for i in range(n-1):
            r[preSum[i]] += 1
        for i in range(n):
            delte = k-nums[i] # old + delte = new
            ssum = preSum[-1] + delte
            # 我尼玛就离谱，这个地方忘记判断了，debug了半个多小时，一直找不到问题出在哪
            if ssum & 1 == 0:
                val = r[ssum//2 - delte] + l[ssum//2]
                res = max(res, val)
            l[preSum[i]] += 1
            r[preSum[i]] -= 1
        return res
