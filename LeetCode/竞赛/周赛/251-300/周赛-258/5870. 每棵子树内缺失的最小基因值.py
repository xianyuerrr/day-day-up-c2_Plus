class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        status = [False] * (pow(10, 5) + 1)
        n = len(parents)
        res = [0] * n
        cnt = [0] * n

        for i in range(n):
            if parents[i] != -1:
                cnt[parents[i]] += 1
        
        def dfs(i):
            