class Solution:
    def kItemsWithMaximumSum(self, numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
        # 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1
        # 非负整数 numOnes 、numZeros 、numNegOnes 和 k
        # 恰好选出 k 件物品，物品上所标记数字之和的最大值
        return min(numOnes, k) if numOnes + numZeros >= k else numOnes - (k - numOnes - numZeros)
