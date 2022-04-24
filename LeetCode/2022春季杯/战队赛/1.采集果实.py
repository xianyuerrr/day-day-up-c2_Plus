class Solution:
    def getMinimumTime(self, time: List[int], fruits: List[List[int]], limit: int) -> int:
        cur = 0
        for fruit in fruits:
            while fruit[1] > 0:
                fruit[1] -= min(fruit[1], limit)
                cur += time[fruit[0]]
        return cur