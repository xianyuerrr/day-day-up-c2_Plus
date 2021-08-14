class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        i = 0
        n = len(s)
        for word in words:
            for ch in word:
                if i < n and ch == s[i]:
                    i += 1
                else:
                    # s 提前遍历完成或当前字符不匹配
                    return False
            if i == n:
                # 此时满足前缀定义
                return True
        # 遍历完成 words 时 s 仍未遍历完成
        return False
