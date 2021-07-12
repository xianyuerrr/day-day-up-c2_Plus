from math import gcd
n, q = list(map(int, input().split()))

mat = [[1 if i < j and gcd(i, j) == 1 else -1 for i in range(n+1)] for j in range(n+1)]



while q:
    q -= 1
    v, u = list(map(int, input().split()))
    dis = [0 for j in range(n+1)]

    if u == v:
        print(0)

    sum_set = set([i for i in range(1, n+1)])
    sum_set.remove(u)
    queue = [u]
    count = -1
    flag = False
    while queue:
        count += 1
        new_queue = []
        if v in queue:
            flag = True
            break
        for i in queue:
            for j in sum_set.copy():
                if mat[i][j] == 1:
                    dis[j] = i
                    new_queue.append(j)
                    sum_set.remove(j)
        queue = new_queue

    if flag:
        print(count, end=' ')
        res = [v]
        while dis[v] != 0:
            res.append(dis[v])
            v = dis[v]
        for i in range(len(res)):
            if i != len(res)-1:
                print(res[i], end=' ')
            else:
                print(res[i])
    else:
        print(-1)