class Solution:
    def stocks(self , n , stocks ):
        res = [0] * n
        stk = [-1]
        for i in range(n):
            while stk[-1] != -1 and stocks[i] > stocks[stk[-1]]:
                res[stk[-1]] = i - stk[-1]
                stk.pop()
            stk.append(i)
        while stk[-1] != -1:
            res[stk.pop()] = 0
        return res

s = Solution()
n = 10
stocks = [11,15,16,12,8,16,18,17,11,10]
print(s.stocks(n, stocks))