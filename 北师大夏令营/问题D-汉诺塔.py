n, q = list(map(int, input().split()))

def qpow(x, y, m):
    ret = 1
    while y:
        if y & 1:
           ret = ret * x % m
        x = x * x % m
        y >>= 1
    return ret

print((qpow(3, n, q)-1) % q)