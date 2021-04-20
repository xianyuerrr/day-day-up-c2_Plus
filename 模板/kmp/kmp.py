class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n == 0:
            return 0
        if n > m:
            return -1

        next = [0 for _ in range(n+1)]
        idx = 0
        for i in range(1, n):          
            while needle[i] != needle[idx] and idx != 0:
                idx = next[idx]
            idx += needle[i] == needle[idx]
            next[i+1] = idx

        idx = 0
        for i in range(m):
            # 如果 needle 未匹配的长度 大于 haystack 未匹配的长度
            # 那么无论如何都不再能匹配成功了
            if n - idx > m - i:
                break
            while haystack[i] != needle[idx] and idx != 0:
                idx = next[idx]
            idx += haystack[i] == needle[idx]
            if idx == n:
                return i - n + 1
        return -1
