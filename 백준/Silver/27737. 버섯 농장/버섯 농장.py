from collections import deque
import math
N,M,K = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [1,-1,0,0]
dix = [0,0,1,-1]
ans = 0
def bfs(ny,nx):
    global arr
    q = deque()
    q.append([ny,nx])
    arr[ny][nx] = 1
    cnt = 0
    while q:
        y,x = q.popleft()
        cnt += 1
        for k in range(4):
            dy = diy[k] + y
            dx = dix[k] + x
            if dy < 0 or dx < 0 or dy >= N or dx >= N:
                continue
            if arr[dy][dx] == 0:
                arr[dy][dx] = 1
                q.append([dy,dx])
    return math.ceil(cnt/K)



for i in range(N):
    for j in range(N):
        if arr[i][j] == 0:
            ret = bfs(i,j)
            ans += ret

if ans == 0:
    print('IMPOSSIBLE')
elif M-ans<0:
    print('IMPOSSIBLE')
else:
    print('POSSIBLE')
    print(M-ans)



