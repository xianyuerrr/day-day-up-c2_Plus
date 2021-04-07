from functools import lru_cache
class Solution:
    def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
        a = pow(10, 9) + 7
        mat = [[] for _ in range(n)]
        for x, y, w in edges:
            mat[x-1].append([y-1, w])
            mat[y-1].append([x-1, w])
        # print(mat)
        for idx in range(n):
            mat[idx].sort(key=lambda x: x[1])
        dtl = [-1 for _ in range(n)]
        # 建立 dtl
        def dfs(idx, dis):
            if dtl[idx] == -1:
                dtl[idx] = dis
            else:
                if dtl[idx] <= dis:
                    return
                else:
                    dtl[idx] = dis
            for j, w in mat[idx]:
                dfs(j, dis+w)
            return
        dfs(n-1, 0)

        @lru_cache
        def find_ways(idx):
            if idx == n-1:
                return 1
            ans = 0
            for j, w in mat[idx]:
                if dtl[idx] > dtl[j]:
                    ans += find_ways(j)
            return ans % a
        return find_ways(0) % a



