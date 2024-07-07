class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        n = len(candyType)
        cnt = len(set(candyType))
        return min(cnt, n // 2)