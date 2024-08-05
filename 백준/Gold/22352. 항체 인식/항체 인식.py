from collections import deque
from copy import deepcopy


def bfs(ny,nx,flag):
    arr = deepcopy(before_arr)
    arr[ny][nx] = flag
    q = deque()
    q.append((ny,nx))
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = di[i][0] + y
            dx = di[i][1] + x
            if dx<0 or dx>=M or dy<0 or dy>=N:
                continue
            if used[dy][dx] == 1:
                continue
            if before_arr[dy][dx] == before_arr[y][x]:
                used[dy][dx] = 1
                arr[dy][dx] = flag
                q.append((dy,dx))
    return arr


N,M = map(int,input().split())
before_arr = [list(map(int,input().split())) for _ in range(N)]
After_arr = [list(map(int,input().split())) for _ in range(N)]
used = [[0]*M for _ in range(N)]
di = [(0,1),(0,-1),(1,0),(-1,0)]


for i in range(N):
    for j in range(M):
        if used[i][j] == 0:
            used[i][j] = 1
            arr = bfs(i,j,After_arr[i][j])
            if arr == After_arr:
                print('YES')
                exit()
print('NO')