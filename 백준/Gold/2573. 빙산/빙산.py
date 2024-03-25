from collections import deque
import sys
input = sys.stdin.readline


def bfs(ny,nx):
    q = deque()
    q.append((ny, nx))
    used[ny][nx] = True

    while q:
        y, x = q.popleft()
        for k in range(4):
            dy = diy[k] + y
            dx = dix[k] + x
            if dy < 0 or dy >= N or dx < 0 or dx >= M:
                continue
            if arr[dy][dx] == 0:
                used[y][x] += 1

            if not used[dy][dx] and arr[dy][dx] != 0:
                q.append((dy, dx))
                used[dy][dx] = True


N,M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
ans = 0

while 1:
    used = [[0] * M for _ in range(N)]
    ice = 0
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0 and used[i][j] == 0 :
                bfs(i, j)
                ice += 1

    for i in range(N):
        for j in range(M):
            if used[i][j]:
                arr[i][j] -= (used[i][j]-1)
            if arr[i][j] <0: arr[i][j] = 0

    ans += 1
    if ice == 0:
        print(0)
        exit()
    if ice>=2:
        break

print(ans-1)