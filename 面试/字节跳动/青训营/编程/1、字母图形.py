s = input()
n = len(s)
while n:
    print(s)
    s = s[-2:] + s[:-2]
    n -= 1