class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        # 暴力，低空飘过
        def dis_2(x1, y1, x2, y2):
            return (x1 - x2)**2 + (y1 - y2) ** 2
        n = len(queries)
        res = [0 for _ in range(n)]
        for i in range(n):
            for xi, yi in points:
                if queries[i][2] ** 2 >= dis_2(queries[i][0], queries[i][1], xi, yi):
                    res[i] += 1
        return res