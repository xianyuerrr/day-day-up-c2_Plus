row = int(input())

def test(lis_1, lis_2):
    n = len(lis_1)
    for i in range(n-1):
        if lis_1[i] < lis_1[i+1]:
            if lis_2[i] > lis_2[i+1]:
                return False
        elif lis_1[i] > lis_1[i+1]:
            if lis_2[i] < lis_2[i+1]:
                return False
    return True


while row:
    row -= 1
    n = int(input())
    lis_1 = list(map(int, input().split()))
    lis_2 = list(map(int, input().split()))

        
    if test(lis_1, lis_2):
        print("Yes")
    else:
        print("No")