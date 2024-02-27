from collections import deque
M,N = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
q = deque()
diy = [0,0,1,-1]
dix = [1,-1,0,0]
ans = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            q.append([i,j,0])

while q:
    y,x,cnt = q.popleft()
    if cnt >ans:
        ans = cnt
    for i in range(4):
        dy = diy[i] + y
        dx = dix[i] + x
        if dy<0 or dx<0 or dy>=N or dx>=M:
            continue
        if arr[dy][dx] ==0:
            arr[dy][dx] = 1
            q.append([dy,dx,cnt+1])

flag = 1
for i in arr:
    for j in i:
        if j == 0:
            flag = 0
if flag:
    print(ans)
else:
    print(-1)