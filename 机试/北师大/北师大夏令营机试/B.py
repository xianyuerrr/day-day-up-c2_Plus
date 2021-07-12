row = int(input())

def test(lis_1, lis_2, a, b):
    n = len(lis_1)
    for i in range(n):
        if a[i] == b[i] or lis_1[a[i]] == lis_1[b[i]] or lis_2[b[i]] == lis_2[a[i]]:
            continue
        else:
            return False
    return True


while row:
    row -= 1
    n = int(input())
    a = [i for i in range(n)]
    b = [i for i in range(n)]
    lis_1 = list(map(int, input().split()))
    lis_2 = list(map(int, input().split()))
    a.sort(key=lambda x:lis_1[x])
    b.sort(key=lambda x:lis_2[x])
        
    if test(lis_1, lis_2, a, b):
        print("Yes")
    else:
        print("No")