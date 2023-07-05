# lis = [1, 20, 3, 20, 21, 14, 2, 3, 4, 6, 7, 8, 22, 23, 9, 10, 11, 13, 12, 13, 14, 15, 18, 19, 15, 18, 19, 19, 16, 18, 19]
# res = []
# for i in lis:
#     if i in res:
#         pass
#     else:
#         res.append(i)
# for i in range(len(res)):
#     print("old: ", res[i], " new: ", i+1)

addEverysecond = 25
queue = 0
time = 0
completed = 0
res = []
while (queue < 3000):
    time += 1
    if (time % 5 == 0) :
        queue += addEverysecond - 15
        completed += 15
    else:
        queue += addEverysecond
    res.append([time, completed, queue])
for i in res:
    print(i)