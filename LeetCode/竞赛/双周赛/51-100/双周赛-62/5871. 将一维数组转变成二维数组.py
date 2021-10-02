class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        if m * n != len(original):
            return []
        res = []
        idx = 0
        for i in range(m):
            ans = []
            for j in range(n):
                ans.append(original[idx])
                idx += 1
            res.append(ans)
        return res