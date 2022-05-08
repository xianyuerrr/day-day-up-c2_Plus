
    from functools import lru_cache


    class Solution:
        mod = pow(10, 9) + 7
        dic = {'2': 3, '3': 3, '4': 3, '5': 3, '6': 3, '7': 4, '8': 3, '9': 4}

        def countTexts(self, pressedKeys: str) -> int:
            n = len(pressedKeys)
            res = 1
            slow = 0
            for fast in range(n+1):
                if (fast == n or pressedKeys[fast] != pressedKeys[slow]):
                    res *= self.getSubCnt(fast - slow, self.dic[pressedKeys[slow]])
                    res %= self.mod
                    slow = fast
            return res

        @lru_cache()
        def getSubCnt(self, length, letters):
            if length < 0:
                return 0
            if length == 1 or length == 0:
                return 1
            res = 0
            for i in range(1, letters + 1):
                res += self.getSubCnt(length-i, letters)
            return res

            # 常规dfs
            # def dfs(idx, ans):
            #     nonlocal res
            #     if (idx == n):
            #         res = (res + ans) % self.mod
            #         return
            #     dfs(idx+1, ans)
            #     for delte in range(1, self.dic[pressedKeys[idx]]+1):
            #         if (idx + delte < n and pressedKeys[idx] == pressedKeys[idx+delte]):
            #             dfs(idx+delte+1, ans)
            #         else:
            #             break
            # dfs(0, 1)
            # return res