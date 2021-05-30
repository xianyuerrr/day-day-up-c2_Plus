class Solution:
    def maxValue(self, n: str, x: int) -> str:
        label = True
        if n[0] == '-':
            label = False
            n = n[1:]
        length = len(n)
        if label:
            for i in range(length):
                if ord(n[i]) - ord('0') < x:
                    return n[:i] + str(x) + n[i:]
            return n + str(x)
        else:
            for i in range(length):
                if ord(n[i]) - ord('0') > x:
                    return '-' + n[:i] + str(x) + n[i:]
            return '-' + n + str(x)