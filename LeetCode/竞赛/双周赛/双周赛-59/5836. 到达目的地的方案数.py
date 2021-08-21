from typing import *
from heapq import heapify, heappush, heappop
class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        mod = pow(10, 9) + 7
        mat = [[-1 for _ in range(n)] for __ in range(n)]
        # 初始化邻接矩阵
        for i in range(n):
            mat[i][i] = 0
        for i, j, v in roads:
            mat[i][j] = v
            mat[j][i] = v
        
        # tim_lis: 从0开始到i需要花费的最短时间，-1 代表不可达
        tim_lis = [-1 for _ in range(n)]
        # 初始化，起始结点到自己的耗时肯定是0
        tim_lis[0] = 0

        # cnt_lis: 从0开始到 i 需要花费最少的路径数目
        cnt_lis = [0 for _ in range(n)]
        cnt_lis[0] = 1
        # 初始化，起始结点到自己不用移动，也就是有一条耗时为 0 的路径

        # vis_lis: 记录未访问过的结点
        vis_lis = set(range(n))

        while vis_lis:
            min_val = 0
            min_idx = 0
            # 寻找当前未访问过的结点里，可达，且耗时最短的结点
            # 第一次除起始点外都不可达，肯定选择起始点
            for i in vis_lis:
                # 排除当前不可达的结点
                if tim_lis[i] == -1:
                    continue
                else:
                    # 用遇到的第一个未访问且可达的结点赋值
                    if min_val == 0:
                        min_val = tim_lis[i]
                        min_idx = i
                    # 寻找耗时更短的结点
                    else:
                        if min_val > tim_lis[i]:
                            min_val = tim_lis[i]
                            min_idx = i
            
            vis_lis.remove(min_idx)

            for i in range(1, n):
                # 排除掉不可达 和 自联结
                if mat[min_idx][i] > 0:
                    new_tim = tim_lis[min_idx] + mat[min_idx][i]
                    # 如果当前结点原来不可达, 或者通过 min_idx 再到当前结点耗时更短
                    if tim_lis[i] == -1 or new_tim < tim_lis[i]:
                        tim_lis[i] = new_tim
                        cnt_lis[i] = cnt_lis[min_idx]
                    elif new_tim == tim_lis[i]:
                        cnt_lis[i] = (cnt_lis[i] + cnt_lis[min_idx]) % mod

        return cnt_lis[-1]

