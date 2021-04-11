class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n <= 0:
            return False
        count = 1
        dp = [0 for _ in range(n+1)]
        dp[1] = 1
        m_2, m_3, m_5 = 1, 1, 1
        num_2, num_3, num_5 = 2*dp[m_2], 3*dp[m_3], 5*dp[m_5]
        for i in range(2, n+1):
            m = min(num_2, num_3, num_5)
            dp[i] = m
            if m == num_2:
                m_2 += 1
                num_2 = 2 * dp[m_2]
            if m == num_3:
                m_3 += 1
                num_3 = 3 * dp[m_3]
            if m == num_5:
                m_5 += 1
                num_5 = 5 * dp[m_5]
        return dp[-1]