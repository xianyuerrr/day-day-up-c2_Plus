def func():
    n = int(input())
    s = bin(n)[2:]
    a = s.count('1')
    b = 1
    for i in range(1, len(s)):
        if s[i] != s[i-1]:
            b += 1
    print(min(a, b))
    return

func() 