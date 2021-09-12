def func():
    n = int(input())
    name_lis = []
    cost_lis = []
    nexts_lis = []

    # 输入元素
    i = 0
    while i < n:
        lis = list(filter(lambda x : x != '', input().split(' ')))
        lis_length = len(lis)
        name_lis.append(lis[0])
        cost_lis.append(int(lis[1]))
        if lis_length == 2:
            nexts_lis.append([])
        else:
            nexts_lis.append(list(map(int, lis[2:])))
        i += 1

    # 记录入度（入度为0即可开始），开始、结束时间
    in_cnt = [0] * n
    begin_time = [0] * n
    end_time = [0] * n
    for i in range(n):
        for nxt in nexts_lis[i]:
            in_cnt[nxt] += 1

    q = []
    new_q = []
    # 初始化
    for i in range(n):
        if in_cnt[i] == 0:
            q.append(i)
    # 广度优先的思想
    while q:
        for i in q:
            end_time[i] = begin_time[i] + cost_lis[i]
            for j in nexts_lis[i]:
                in_cnt[j] -= 1
                begin_time[j] = max(begin_time[j], end_time[i])
                if in_cnt[j] == 0:
                    new_q.append(j)
        q.clear()
        q, new_q = new_q, q

    print(max(end_time))


func()