class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        have = [0] * 101
        for i in logs:
            for j in range(i[0]-1950, i[1]-1950):
                have[j] += 1
        res = [0, 0]
        for i in range(101):
            if have[i] > res[0]:
                res = [have[i], i]
        return res[1] + 1950