# from math import comb
from math import factorial
import math
T = int(input())

def qpow(x, y, m):  
    x %= m
    ret = 1
    while y:
        if y & 1:
            ret = ret * x % m
        y >>= 1
        x = x * x % m
    # print('ret:', ret)
    return ret

def comb(n, k):
    return factorial(n) / factorial(k) / factorial(n-k) % mod

mod = 998244353
while T:
    T -= 1
    n, k = list(map(int, input().split()))

    if n < 3 or k < 21:
        print(0)
        continue
    print(((n-2)%mod)*qpow(k, n-3, mod) % mod)
    # print((comb(n, 3)%mod)*qpow(k, n-3, mod) % mod)

    
    
