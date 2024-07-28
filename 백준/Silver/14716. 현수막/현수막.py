import sys
input = sys.stdin.readline
sys.setrecursionlimit(62500)

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
diy = [1,-1,1,-1,0,0,1,-1]
dix = [1,-1,-1,1,1,-1,0,0]
used = [[0]*M for _ in range(N)]
ans = 0
def dfs(y, x):
    global used
    for i in range(8):
        dy = diy[i] + y
        dx = dix[i] + x
        if dy<0 or dy>=N or dx<0 or dx>=M:
            continue
        if arr[dy][dx] == 0:
            continue
        if used[dy][dx] == 1:
            continue
        used[dy][dx] = 1
        dfs(dy,dx)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1 and used[i][j] == 0:
            used[i][j] = 1
            ans += 1
            dfs(i, j)

print(ans)