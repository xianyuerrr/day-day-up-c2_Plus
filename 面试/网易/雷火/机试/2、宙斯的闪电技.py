from collections import defaultdict
def func():
    r = int(input())
    Num = int(input())
    lengeth = 10001
    dis = defaultdict(lambda: defaultdict(int))
    xMax = 0
    yMax = 0
    for i in range(Num):
        x, y = list(map(int, input().split()))
        xMax = max(xMax, x)
        yMax = max(yMax, y)
        dis[x][y] += 1

    # 应该根据遍历敌军遍历，平面上的点太稀疏了
    dp = [[i*i + j*j <= r*r for j in range(r+1)] for i in range(r+1)]
    lPre = []; rNow = []; uPre = []; dNow = []
    for i in range(r+1):
        for j in range(r+1):
            if dp[i][j] and (i == r or not dp[i+1][j]):
                rNow.append((i, j))
                rNow.append((-i, j))
                lPre.append((i, -j))
                lPre.append((-i, -j))
            if dp[i][j] and (j == r or not dp[i][j+1]):
                uPre.append((-i, j))
                uPre.append((-i, -j))
                dNow.append((i, j))
                dNow.append((i, -j))
    res = [0] * min(lengeth, yMax+r+1)
    for i in range(r+1):
        for j in range(r+1):
            if dp[i][j]:
                res[0] += dis[i][j]
    mmax = res[0]
    pos = [0, 0]
    for i in range(min(lengeth, xMax+r+1)):
        for j in range(min(lengeth, yMax+r+1)):
            ans = resj_1 = resj_2 = 0
            if i > 0:
                for dx, dy in uPre:
                    xx, yy = i-1+dx, j+dy
                    # if xx < 0 or xx > lengeth-1 or yy < 0 or yy > lengeth-1:
                    #     continue
                    ans -= dis[xx][yy]
                for dx, dy in dNow:
                    xx, yy = i+dx, j+dy
                    # if xx < 0 or xx > lengeth-1 or yy < 0 or yy > lengeth-1:
                    #     continue
                    ans += dis[xx][yy]
                resj_1 = res[j]+ans
            if j > 0:
                for dx, dy in lPre:
                    xx, yy = i+dx, j-1+dy
                    # if xx < 0 or xx > lengeth-1 or yy < 0 or yy > lengeth-1:
                    #     continue
                    ans -= dis[xx][yy]
                for dx, dy in rNow:
                    xx, yy = i+dx, j+dy
                    # if xx < 0 or xx > lengeth-1 or yy < 0 or yy > lengeth-1:
                    #     continue
                    ans += dis[xx][yy]
                resj_2 = res[j-1]+ans
            res[j] = max(resj_1, resj_2)
            if res[j] > mmax:
                pos = [i, j]
                mmax = res[j]
            elif res[j] == mmax:
                pos = [max(pos[0], i), max(pos[1], j)]
    print(pos[1]-1, pos[0]-1)
    return

func()