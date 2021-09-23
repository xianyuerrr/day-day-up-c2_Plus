def func():
    n, m = list(map(int, input().split()))
    lis = [[0, 0, 0, 0] for _ in range(n*m+1)]
    # 图片被打乱了顺序
    res = [[0] * m for _ in range(n)]
    q = None
    for i in range(m*n):
        idx, left, up, right, down = list(map(int, input().split()))
        lis[idx] = [left, up, right, down]
        if left == 0 and up == 0:
            q = idx
    for i in range(n):
        nextQ = lis[q][-1]
        cnt = 0
        while cnt < m:
            res[i][cnt] = q
            q = lis[q][2]
            cnt += 1
        q = nextQ
    for i in range(n):
        for j in range(m):
            print(res[i][j], end='')
            if j != m-1:
                print(' ', end='')
        if i != n-1:
            print()

func()
        
        
