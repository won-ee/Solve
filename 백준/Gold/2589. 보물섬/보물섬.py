from collections import deque


def bfs(ny,nx):
    used = [[0]*M for _ in range(N)]
    used[ny][nx] = 1
    q = deque()
    q.append((ny,nx,0))
    flag = 0
    while q:
        y,x,cnt = q.popleft()
        flag = max(flag,cnt)
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=N or dx<0 or dx>=M:
                continue
            if arr[dy][dx] == 'W':
                continue
            if used[dy][dx] == 1:
                continue
            used[dy][dx] = 1
            q.append((dy,dx,cnt+1))

    return flag

N,M = map(int,input().split())
arr = [list(input()) for _ in range(N)]
ans = 0
diy = [0,0,1,-1]
dix = [1,-1,0,0]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'L':
            ret = bfs(i,j)
            ans = max(ans,ret)

print(ans)