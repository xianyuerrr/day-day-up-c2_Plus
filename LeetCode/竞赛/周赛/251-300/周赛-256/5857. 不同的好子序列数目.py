class Solution:
    def numberOfUniqueGoodSubsequences(self, binary: str) -> int:
        mod = pow(10, 9) + 7
        n = len(binary)
        res = 0

        l_lis = [0] * n
        r_lis = [0] * n
        l = 0
        r = 0
        for i in range(n):
            if binary[i] == '0':
                l += 1
            else:
                r += 1
            l_lis[i] = l
            r_lis[i] = r
        print(l_lis)
        print(r_lis)
