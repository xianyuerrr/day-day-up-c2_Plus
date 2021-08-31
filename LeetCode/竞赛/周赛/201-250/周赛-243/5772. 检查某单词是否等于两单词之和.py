class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        def change(s):
            n = len(s)
            cnt = 0
            for i in range(n):
                cnt = cnt * 10 + ord(s[i]) - ord('a')
            return cnt
        return change(firstWord) + change(secondWord) == change(targetWord)