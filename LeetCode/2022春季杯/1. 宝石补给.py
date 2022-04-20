class Solution:
    def giveGem(self, gem: List[int], operations: List[List[int]]) -> int:
        for x, y in operations:
            delte = gem[x] >> 1
            gem[x] -= delte
            gem[y] += delte
        return max(gem) - min(gem)