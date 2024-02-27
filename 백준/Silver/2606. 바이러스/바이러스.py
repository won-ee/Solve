from collections import deque
N = int(input())
M = int(input())
arr = [[0]*(N+1) for _ in range(N+1)]
used = [0]*(N+1)
for _ in range(M):
    a,b = map(int,input().split())
    arr[a][b] = 1
    arr[b][a] = 1

def bfs():
    q = deque()
    q.append(1)
    while q:
        now = q.popleft()
        for i in range(N+1):
            if arr[now][i] == 0:
                continue
            if used[i] == 1:
                continue
            used[i] = 1
            q.append(i)
used[1] = 1
bfs()
print(used.count(1) - 1)