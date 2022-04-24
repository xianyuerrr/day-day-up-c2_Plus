from typing import *
from heapq import *


class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:
        m = len(flowers)
        n = len(persons)

        # 把花期表按照花期开始时间排序
        flowers.sort()
        flower_idx = 0

        res = [0] * n
        q = []
        size = 0

        for cur, idx in sorted(zip(persons, range(n)), key=lambda x: x[0]):
            # 把花期已经结束的弹出堆
            while size > 0 and q[0] < cur:
                heappop(q)
                size -= 1
            # 将花期应该在 cur 前（包括 cur）已经开始，否则 cur 时刻此花不可能处于花期
            while flower_idx < m and flowers[flower_idx][0] <= cur:
                # 花期在 cur 还未结束，若花期在 cur 已经结束，那么就不可能在 cur 以及之后的时刻处于花期
                if flowers[flower_idx][1] >= cur:
                    heappush(q, flowers[flower_idx][1])
                    size += 1
                flower_idx += 1
            # print(cur, q)
            res[idx] = size
        return res
