def func():
    n = int(input())
    nn = n
    res = 0
    while nn:
        a = nn % 10
        nn //= 10
        if a == 0:
            pass
        else:
            if (n % a == 0):
                res += 1
    print(res)
    return

func()