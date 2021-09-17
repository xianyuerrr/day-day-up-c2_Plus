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

# 深度学习网络模型由若干算子组成，假设其是一个有向无环图。

# 若算子A依赖算子B的输出，则仅当算子B执行完成之后才能执行算子A，没有依赖关系的算子可并行执行。计算运行整个网络所需要的最小时间。

# 输入：总共N+1行，其中N为算子个数。第一行输入整数N(N<=100)。第j(2<= j <= N+1)行输入代表索引为j-2算子的属性，
# 内容包括：“OpName OpCost NextOp1 NextOp2 ... NextOpk”，其中OpName为字符串（不包括空格），
# 代表算子名；OpCost为正整数，代表该算子运行时间；NextOp1-NextOpk代表该算子所指向的下一层算子的索引（0-N-1）。