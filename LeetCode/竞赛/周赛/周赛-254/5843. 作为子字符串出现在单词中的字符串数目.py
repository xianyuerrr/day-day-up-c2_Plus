class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        # 子串，可以使用KMP
        n = len(word)
        res = 0
        for s in patterns:
            if s in word:
                res += 1
            # m = len(s)
            # if m > n:
            #     continue
            # for i in range(n-m):
            #     print(s, word[i:i+m])
            #     if s == word[i:i+m]:
            #         res += 1
        return res