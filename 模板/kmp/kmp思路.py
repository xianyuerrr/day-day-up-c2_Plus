class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n == 0:
            return 0
        if n > m:
            return -1

        next = [0 for _ in range(n+1)]
        # idx = 0时无意义， 1 到 n 存储 子串needle[:i] 的前后缀公共长度
        idx = 0
        for i in range(1, n):
            # 求 needle[0 : i] (闭区间) 的前后缀公共长度
            # idx 表示当前要匹配的字符 idx，小于 idx 的都是已经匹配成功的
            # 如果这一位置匹配上，那么 前后缀公共长度 + 1 ，继续匹配下一位
            if needle[i] == needle[idx]:
                idx += 1
                next[i+1] = idx
                continue
            # 如果匹配不上，只能缩减 已匹配上的字符，寻找更短的 公共前后缀
            # 即 减小idx，尝试匹配其下一位，直至为 0 时仍旧匹配不上
            while idx != 0:
                idx = next[idx]
                if needle[i] == needle[idx]:
                    idx += 1
                    next[i+1] = idx
                    break
        # 朴素求法, O(n^3)
        # for i in range(1, n):
        #     for length in range(1, i+1):
        #         a = needle[:length]
        #         b = needle[i+1-length:i+1]
        #         if a == b:
        #             next[i+1] = length
        
        # print(next)
        idx = 0
        for i in range(m):
            if haystack[i] == needle[idx]:
                idx += 1
            else:
                while idx != 0:
                    idx = next[idx]
                    if haystack[i] == needle[idx]:
                        idx += 1
                        break
            if idx == n:
                return i - n + 1
        return -1

s = Solution()
# haystack = "abeababeabf"
# needle = "abeabf"

haystack = "aabaaabaaac"
needle = "aabaaac"
# needle = "aaabbab"
print(s.strStr(haystack, needle))