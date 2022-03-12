n = int(input())

colors = list(map(int, input().split()))
parents = list(map(int, input().split()))
children = [[] for _ in range(n)]

root = -1
for i in range(n):
    if parents[i] == 0:
        root = i
        continue
    children[parents[i]-1].append(i)

cntBlack = 0
cntWhite = 0

def dfs(node):
    # print(node)
    global cntBlack, cntWhite
    if colors[node] == 0:
        if len(children[node]) == 0 or len(list(filter(lambda x : colors[x] == 1, children[node]))) > 0:
            cntWhite += 1
    else:
        if len(children[node]) == 0 or len(list(filter(lambda x : colors[x] == 1, children[node]))) == 0:
            cntBlack += 1
    for child in children[node]:
        dfs(child)
dfs(root)
print(cntWhite, cntBlack)
