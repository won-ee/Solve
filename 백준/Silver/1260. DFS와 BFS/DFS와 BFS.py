from collections import deque
N,M,V = map(int,input().split())
arr = [[0]*(N+1) for _ in range(N+1)]
used = [0] * (N+1)

for i in range(M):
    y,x = map(int,input().split())
    arr[y][x] = 1
    arr[x][y] = 1

def dfs(now):
    print(now,end=' ')
    if now == N+1:
        return
    for i in range(N+1):
        if used[i] == 1:
            continue
        if arr[now][i] == 0:
            continue
        used[i] = 1
        dfs(i)


def bfs(st):
    q = deque()
    q.append(st)
    while q:
        now = q.popleft()
        print(now,end=' ')
        for i in range(N+1):
            if arr[now][i] == 1 and used[i] == 0:
                used[i] = 1
                q.append(i)


used[V] = 1
dfs(V)
print()
used = [0] * (N+1)
used[V]=1
bfs(V)
