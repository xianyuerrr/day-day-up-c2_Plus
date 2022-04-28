from typing import *
from heapq import *


class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:
        m = len(flowers)
        n = len(persons)
        res = [0] * n

        # 把花期表按照花期开始时间排序

        # 正在开的花的个数 为所有在此时间节点及之前开放的花的个数减去在时间节点之前凋谢的花的个数
        open = [x for x, y in flowers]
        close = [y for x, y in flowers]
        open.sort(), close.sort()
        open_cnt = close_cnt = 0
        for cur, idx in sorted(zip(persons, range(n)), key=lambda x: x[0]):
            while open_cnt < n and open[open_cnt] <= cur:
                open_cnt += 1
            while close_cnt < n and close[close_cnt] < cur:
                close_cnt += 1
            res[idx] = open_cnt - close_cnt
        return res


        flowers.sort()
        flower_idx = 0
        q = []
        size = 0

        # 按时间遍历 + 小根堆存储结束时间 + 延迟删除
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
