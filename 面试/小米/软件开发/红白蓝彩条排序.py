def myFunc():
    lis = list(map(int, input().split()))
    cnt = [0] * 4
    for i in lis:
        cnt[i] += 1
    ssum = sum(cnt)
    for i in range(1, 4):
        while cnt[i]:
            print(i, end='')
            ssum -= 1
            cnt[i] -= 1
            if ssum:
                print(' ', end='')
    return

myFunc()