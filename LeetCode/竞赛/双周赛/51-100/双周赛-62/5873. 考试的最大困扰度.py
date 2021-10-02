class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        # O(n) 或者 O(logn)
        n = len(answerKey)
        preCnt = [0] * n
        for i in range(n):
            preCnt[i] = (preCnt[i-1] if i > 0 else 0) + (answerKey[i] == 'T')
        l = 0
        r = n

        def test(m):
            for i in range(n-m+1):
                if preCnt[i+m-1] - (preCnt[i-1] if i != 0 else 0) <= k:
                    return True
            return False

        while l < r:
            m = l + (r-l >> 1) + 1
            if test(m):
                l = m
            else:
                r = m-1
        a = l

        preCnt = [0] * n
        for i in range(n):
            preCnt[i] = (preCnt[i-1] if i > 0 else 0) + (answerKey[i] == 'F')
        l = 0
        r = n

        while l < r:
            m = l + (r-l >> 1) + 1
            if test(m):
                l = m
            else:
                r = m-1
        b = l
        print(a, b)
        return max(a, b)