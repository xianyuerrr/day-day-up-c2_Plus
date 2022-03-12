n = int(input())

def has2One(num):
    cnt = 0
    while num:
        if num % 10 == 1:
            cnt += 1
            if cnt == 2:
                return True
        num = num // 10
    return False
    
for i in range(n):
    num = int(input())
    flag = num % 11 == 0 or has2One(num)

    if flag:
        print("yes")
    else:
        print("no")
