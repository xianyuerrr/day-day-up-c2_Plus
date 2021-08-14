class Solution:
    def sortSentence(self, s: str) -> str:
        lis = s.split()
        print(lis)
        n = len(lis)
        res = [None for _ in range(n)]
        for i in range(n):
            idx = int(lis[i][-1]) - 1
            res[idx] = lis[i][:-1]
        return ' '.join(res)