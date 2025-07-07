from typing import List


# 考虑无后效性，从后往前定义状态
class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        dp = [0] * (len(questions) + 1)
        for i in range(len(questions) - 1, -1, -1):
            point, brainpower = questions[i]
            nextQuestion = min(len(questions), i + brainpower + 1)
            dp[i] = max(point + dp[nextQuestion], dp[i + 1])
        return dp[0]