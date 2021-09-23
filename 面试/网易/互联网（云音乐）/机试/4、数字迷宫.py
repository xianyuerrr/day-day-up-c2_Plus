def func():
    n, a, b = list(map(int, input().split()))
    dp = [[float('inf')] * n for _ in range(n)]
    dp[0][0] = 0
    lis = []
    for i in range(n):
        lis.append(input())
    trans = []
    for i in range(n):
        for j in range(n):
            if lis[i][j] == '*':
                trans.append((i, j))

    q = [(0, 0)]
    nq = []
    directions = ((0, 1), (0, -1), (1, 0), (-1, 0))
    while q:
        for x, y in q:
            if x == n-1 and y == n-1:
                continue
                # return
            if lis[x][y] == '*':
                for xx, yy in trans:
                    if dp[xx][yy] > dp[x][y] + b:
                        dp[xx][yy] = dp[x][y]+b
                        nq.append((xx, yy))
            for dx, dy in directions:
                xx, yy = x+dx, y+dy
                if xx < 0 or xx >= n or yy < 0 or yy >= n:
                    continue
                if lis[xx][yy] == '#':
                    if dp[xx][yy] > dp[x][y] + a:
                        nq.append((xx, yy))
                        dp[xx][yy] = dp[x][y] + a
                else:
                    if dp[xx][yy] > dp[x][y]:
                        nq.append((xx, yy))
                        dp[xx][yy] = dp[x][y]
        q.clear()
        q, nq = nq, q
    print(dp[-1][-1])
    return 

func()
