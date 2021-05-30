class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        n = len(dist)
        res = 0
        pre_sum = [dist[0] for _ in range(n)]
        for i in range(1, n):
            pre_sum[i] = pre_sum[i-1] + dist[i]
        if pre_sum[-1] / speed > hoursBefore:
            return -1
        