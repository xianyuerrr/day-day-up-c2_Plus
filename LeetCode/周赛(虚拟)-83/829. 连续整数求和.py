class Solution(object):
    def consecutiveNumbersSum(self, N):
        # N = (x+1) + ... + (x+k)
        # N = kx + k(k+1)/2
        # 2N = k * (2x+k+1)
        # 问题转化成：可以取到多少组不同的 k 和 (2x+k+1)
        # k * (2x+k+1) 必定是 一奇数、一偶数，可以写成 pow(2, a) * b 的形式 (b为奇数)
        # 问题再度转化为 奇数 b 有多少种拆分方式
        
        while N & 1 == 0:
            N >>= 1

        ans = 1
        d = 3
        while d * d <= N:
            e = 0
            while N % d == 0:
                N /= d
                e += 1
            # 可以给 k 分 0 个 到 e 个 因子 d，剩下的分给 2x+k+1
            ans *= e + 1
            d += 2
        # 只会有一个因子剩下，因为 N 是不可能有两个大于 sqrt(N) 的因子的
        # 剩下这个可以分到 k 或者分到 2x+k+1
        if N > 1: ans *= 2
        return ans