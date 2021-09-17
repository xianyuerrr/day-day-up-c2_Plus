def func():
    n, m = list(map(int, input().split()))
    lis = [0] * n
    for i in range(n):
        lis[i] = int(input())

    pre_sum = [0] * (n+1)
    for i in range(1, n+1):
        pre_sum[i] = pre_sum[i-1] + lis[i-1]

    res = -1
    for i in range(n-m+1):
        for j in range(i+m-1, n):
            res = max(res, (pre_sum[j+1] - pre_sum[i]) / (j-i+1))
    print(int(res*1000))

func()