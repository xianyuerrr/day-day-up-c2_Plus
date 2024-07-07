class Solution:
    def smallestString(self, s: str) -> str:
        n = len(s)
        s = list(s)
        cnt = 0
        for i in range(n):
            if (s[i] == 'a'):
                break
            elif cnt == 0:
                s[i] = chr(ord(s[i]) - 1)
        return "".join(s)