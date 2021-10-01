x, y, m = list(map(int, input().split()))
res = 0
if x > y:
    x, y = y, x
if y >= m:
    pass
else:
    if y <= 0 and y < m:
        res = -1
    else:
        if x < 0:
            cnt = (-x) // y + 1
            x += (cnt) * y
            res += cnt

        # 1, 1, 2, 3, 5, 8, ...
        while y < m:
            x = x+y
            res += 1
            x, y = y, x
print(res)