class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()
        res = 0
        for i in costs:
            coins -= i
            if coins >= 0:
                res += 1
            else:
                break
        return res