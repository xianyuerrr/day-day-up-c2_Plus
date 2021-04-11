class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        lis = [1 for _ in range(n)]
        have = n
        idx = 0
        while have != 1:
            ans = k % have if k % have != 0 else k
            while ans != 0:
                if lis[idx]:
                    if ans == 1:
                        lis[idx] = 0
                        have -= 1
                        print(idx)
                        print(lis)
                        print(' ')
                    ans -= 1
                idx = (idx+1) % n
        for i in range(n):
            if lis[i]:
                return i+1
 
