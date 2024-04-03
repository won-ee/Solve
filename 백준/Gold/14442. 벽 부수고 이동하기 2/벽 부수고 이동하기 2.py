from collections import deque
import sys

N,M,K = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
used = [[[0]*(K+1) for _ in range(M)]for _ in range(N)]
ans = 21e8
q = deque()
q.append((0,0,0,0))

while q:
    y,x,cnt,b = q.popleft()
    if y == N-1 and x == M-1:
        ans = cnt
        break
    if b>K:
        continue
    for i in range(4):
        dy = diy[i] + y
        dx = dix[i] + x
        if dy<0 or dy>=N or dx<0 or dx>=M:
            continue

        if arr[dy][dx]== 1 and used[dy][dx][b]==0:
            used[dy][dx][b] = 1
            q.append((dy, dx,cnt+1, b+1))

        elif arr[dy][dx] == 0 and used[dy][dx][b]  == 0:
            used[dy][dx][b]  = 1
            q.append((dy, dx, cnt+1,b))



if ans == 21e8:
    print(-1)
else:
    print(ans+1)