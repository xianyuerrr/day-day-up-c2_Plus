import math

def get_k(k):
    l = k
    r = k*2
    while l < r:
        m = l + (r-l >> 1)
        ans = m - int(math.sqrt(m))
        if ans == k:
            return m
        elif ans > k:
            r = m-1
        else:
            l = m+1
    return l

def fun(n, k):
    if n - int(math.sqrt(n)) == k:
        return n
    return fun(k+int(math.sqrt(n)), k)

row = int(input())
while row:
    row -= 1
    k = int(input())
    print(get_k(k))
    # print(fun(k, k))