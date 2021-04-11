from math import ceil, inf
from heapq import heappush, heappop


class Solution:
    def storeWater(self, bucket: List[int], vat: List[int]) -> int:
        # 这题是一个木桶效应，在不考虑增加容量的时候，需要倒水次数最多的 i 号桶和缸决定了结果
        # 但是吧，又不能不考虑给水桶扩容
        # 不难想到, 如果是需要升级水桶才能达到更短时间，那么在所有倒水操作之前升级桶倒水次数应该最少
        # 因为桶扩容之后相同次数倒水总量会增大
        pq = []
        res = 0
        # 初始化堆队列
        # 不考虑 vat[i] == 0 的情况，因为不需要倒水了
        # 把 bucket[i] == 0 的情况化为 1
        for i in range(len(bucket)):
            if vat[i] == 0:
                continue
            if bucket[i] == 0:
                bucket[i] += 1
                res += 1
            heappush(pq, (-ceil(vat[i]/bucket[i]), i))

        # 单纯的优先级队列是不行的,因为当队列头部拥有众多需要 相同倒水次数 的 桶缸组合 时
        # 就算只减少了最头部的 组合 的倒水数,也不会改善所需要的最大倒水次数(木桶效应)
        # 在局部情况还会导致操作总次数增大
        # 所以应该综合考虑队列头部拥有众多需要 相同倒水次数 的 桶缸组合
        # 看看给这些组合各增加一次容量能否使总操作数减少
        cur_ans = -pq[0][0] if pq else 0
        while pq and pq[0][0] < -1:
            updates = 0
            new_times = inf
            save_times = inf
            cur_ans = -pq[0][0]
            while pq[0][0] == -cur_ans and updates < len(pq):
                i = pq[0][1]
                updates += 1
                bucket[i] += 1
                heappop(pq)
                new_times = ceil(vat[i]/bucket[i])
                save_times = min(save_times, cur_ans - new_times)
                heappush(pq, (-new_times, i))
            if save_times != inf and save_times >= updates:
                res += updates
            else:
                break
        return res + cur_ans