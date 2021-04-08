from collections import defaultdict
import heapq
class Solution:
    def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
        edge = defaultdict(dict)                #既是邻接矩阵，又是邻接表
        for x,y,weight in edges:
            edge[x][y] = weight
            edge[y][x] = weight
        #n为源点，dijkstra单源最短路径,n到各点的最短距离，就是各点到n的最短距离
        dist = [float('inf') for _ in range(n + 1)]
        dist[n] = 0
        visited = set()
        minHeap = [(0, n)]
        while minHeap:
            cloestDist, cloestNode = heapq.heappop(minHeap) #距离源节点最近的结点
            if cloestNode in visited:           #已经在选中的区域里了，就不要再选了
                continue
            visited.add(cloestNode)             #未选择的点中，这是最小的。正式加入区域
            for nxt in edge[cloestNode].keys():      #更新与它相连接的点
                if dist[cloestNode] + edge[cloestNode][nxt] < dist[nxt]:
                    dist[nxt] = dist[cloestNode] + edge[cloestNode][nxt]
                    heapq.heappush(minHeap, (dist[nxt], nxt))              #有更小的了，就进minHeap
        print(dist)
        #动态规划 dp  更多的是一种贪心！！！！！！！！！
        dp = [0 for _ in range(n + 1)]
        dp[n] = 1
        a = [node for node in range(1, n + 1)]
        a.sort(key = lambda x: dist[x])

        for node in a:
            for nxt in edge[node].keys():
                if dist[node] > dist[nxt]:
                    dp[node] += dp[nxt]

            if node == 1:   #a中右侧的点，距离都比1的远了，1的最短路径不可能经过他们到达n
                break
        
        return dp[1] % (10**9 + 7)

# from functools import lru_cache


# class Solution:
#     def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
#         a = pow(10, 9) + 7
#         mat = [[] for _ in range(n)]
#         for x, y, w in edges:
#             mat[x-1].append([y-1, w])
#             mat[y-1].append([x-1, w])
#         # print(mat)
#         for idx in range(n):
#             mat[idx].sort(key=lambda x: x[1])
#         dtl = [-1 for _ in range(n)]

#         # 应该使用迪杰斯特拉算法
#         # 建立 dtl
#         def dfs(idx, dis):
#             if dtl[idx] == -1:
#                 dtl[idx] = dis
#             else:
#                 if dtl[idx] <= dis:
#                     return
#                 else:
#                     dtl[idx] = dis
#             for j, w in mat[idx]:
#                 dfs(j, dis+w)
#             return
#         dfs(n-1, 0)

#         @lru_cache
#         def find_ways(idx):
#             if idx == n-1:
#                 return 1
#             ans = 0
#             for j, w in mat[idx]:
#                 if dtl[idx] > dtl[j]:
#                     ans += find_ways(j)
#             return ans % a
#         return find_ways(0) % a
