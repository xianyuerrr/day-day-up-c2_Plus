from heapq import *
class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        m = len(intervals)
        n = len(queries)

        res = [None for _ in range(n)]
        p = []
        
        intervals.sort()
        new_querier = [[queries[i], i] for i in range(n)]
        new_querier.sort()
        # 对于查询，需要离线处理。
        # 首先将查询列表从小向大排序，同时需要记录原本的位置信息。
        # 将区间列表按照左端点从小到大排序，右端点从小到大排序。

        # 对于每一个查询：
        # 首先将左端点符合条件的插入到优先队列，优先队列按照区间长度，从小到大排序。
        # 然后检查优先队列的堆顶，如果堆顶的右节点满足条件，即查询到结果。
        # 如果不满足就弹出堆顶，继续查询下一个堆顶。
        # 直到满足或者优先队列为空为止。

        # 遍历完所有的查询之后，将区间列表按照原有的位置信息还原。
        # 输出结果即可。
            
        itr_idx = 0
        for querie, idx in new_querier:

            while itr_idx < m and intervals[itr_idx][0] <= querie:
                l, r = intervals[itr_idx]
                heappush(p, (r-l+1, r))
                itr_idx += 1
            res[idx] = -1
            if p:
                val, r = heappop(p)
                while p and r < querie:
                    val, r = heappop(p)
                if r >= querie:
                    heappush(p, (val, r))
                    res[idx] = val

        return res
            

# from bisect import bisect, insort
# class Solution:
#     def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
#         n = len(queries)
#         intervals.sort(key=lambda x : x[1]-x[0])
#         l_idx = 0
#         r_idx = 0
#         m = len(intervals)
#         new_querier = [[queries[i], i] for i in range(n)]
#         new_querier.sort()
        
#         res = [None for _ in range(n)]
#         for querie, idx in new_querier:
#             res[idx] = -1
#             for l, r in intervals:
#                 if l <= querie <= r:
#                     res[idx] = r-l+1
#                     break

#         return res
