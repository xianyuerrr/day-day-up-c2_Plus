n = int(input())
lis = list(map(int, input().split()))
lis.sort(reverse=True)

b = [0] * 6

for i in lis:
    print(i)
    if i == 100:
        b[0] += 1
    elif i >= 90:
        b[1] += 1
    elif i >= 80:
        b[2] += 1
    elif i >= 70:
        b[3] += 1
    elif i >= 60:
        b[4] += 1
    else:
        b[5] += 1
for i in range(len(b)):
    print(b[i], end='')
    if i != len(b)-1:
        print(' ', end='')
    else:
        print('')