from collections import deque


def bfs(ny, nx):
    q = deque()
    q.append([ny,nx])
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy == N:
                dy = 0
            if dx == M:
                dx = 0
            if dy == -1:
                dy = N-1
            if dx == -1:
                dx = M-1
            if arr[dy][dx] == 1:
                continue
            arr[dy][dx] = 1
            q.append([dy,dx])


N, M = map(int,input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
ans = 0

for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            ans += 1
            arr[i][j] = 1
            bfs(i,j)

print(ans)