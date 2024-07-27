N,M = map(int,input().split())
graph = [[] for _ in range(N+1)]
used = [0]*(N + 1)
ans = 0

def dfs(k):
    for i in graph[k]:
        if used[i] == 0:
            used[i] = 1
            dfs(i)

for i in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,N+1):
    if used[i] == 0:
        used[i] = 1
        ans += 1
        dfs(i)


print(ans)