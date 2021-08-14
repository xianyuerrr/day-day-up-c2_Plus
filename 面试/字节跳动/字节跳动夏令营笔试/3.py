from heapq import heappush, heappop
row = int(input())
def check(lis):
    length, a, b = heappop(lis)
    res = 0
    l, r = a, b
    while length > 2:
        res += 1
        m = l + (r-l >> 1)
        heappush(lis, [m-l, l, m-1])
        heappush(lis, [r-m, m+1, r])
        if not lis:
            return res
        length, l, r = heappop(lis)
    while length == 2:
        if l == a or r == b:
            res += 1
        if not lis:
            return res
        length, l, r = heappop(lis)  
    return res

for i in range(row):
    n = int(input())
    l = 1
    r = pow(10, 18)
    while l < r:
        m = l + (r-l >> 1)
        lis = []
        heappush(lis, [m, 1, m])
        if check(lis) < n:
            l = m + 1
        else:
            r = m
    print(l)