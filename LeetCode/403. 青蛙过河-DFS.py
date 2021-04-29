from functools import lru_cache
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        stones_set = set(stones)

        # 相比于以 下标作为 idx，直接以值作为 idx 的优越性很高，免去了搜索值的过程
        # 不是每个 DFS 都是以下标作为迭代对象的
        @lru_cache()
        def dfs(idx, k):
            if idx == stones[-1]:
                return True
            for new_k in (k-1, k, k+1):
                if new_k > 0 and new_k + idx in stones_set and dfs(idx+new_k, new_k):
                    return True
            return False

        return dfs(stones[0], 0)

        ## DFS 又双叒叕超时啦
        # @lru_cache()
        # def dfs(idx, k):
        #     if idx == n-1:
        #         return True
        #     if k < 0:
        #         return False
        #     for i in range(idx + 1, n):
        #         if stones[i] - stones[idx] in (k-1, k, k+1) and dfs(i, stones[i] - stones[idx]):
        #             return True
        #         if stones[i] - stones[idx] > k + 1:
        #             break
        #     return False

        # return dfs(0, 0)