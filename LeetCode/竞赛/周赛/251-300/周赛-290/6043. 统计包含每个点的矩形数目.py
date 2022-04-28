from bisect import bisect_left
from typing import *


class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        # rectangles[i] = [li, hi]
        # 第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi)
        # 1 <= li, xj <= 10**9
        # 1 <= hi, yj <= 100

        m = len(rectangles)
        n = len(points)
        # 如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
        # 即寻找 长宽都比 point 大的 rectangle
        count = [0] * n
        rectangles.sort(key=lambda x: x[1])

        # 存储 y 值大于 point[i] 的所有 point，由于 y 值有序，只用存储 x 值
        lis = []

        indexs = list(range(n))
        # 按照 y 从大到小排序，保证 lis 可以复用
        indexs.sort(key=lambda x: -points[x][1])
        pre_r = m-1

        for i in indexs:
            x, y = points[i]
            r = pre_r
            # 将新增 rectangle 加入lis，直至其 h 值小于 y
            while r >= 0 and rectangles[r][1] >= y:
                lis.append(rectangles[r][0])
                r -= 1
            if r != pre_r:
                lis.sort()
            pre_r = r

            ll = bisect_left(lis, x)
            ll = ll if m - pre_r - 1 == ll or lis[ll] >= x else ll+1
            count[i] = m - pre_r - 1 - ll
        return count
