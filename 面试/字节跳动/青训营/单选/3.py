res = 1
for i in range(1, 101):
    res *= i
cnt = 0
while res % 10 == 0:
    res //= 10
    cnt += 1
print(cnt)