from collections import deque
H,W = map(int,input().split())
arr = [list(input()) for _ in range(H)]
ans = [[-1]*W for _ in range(H)]
q = deque()

for i in range(H-1,-1,-1):
    for j in range(W-1,-1,-1):
        if arr[i][j] == 'c':
            ans[i][j] = 0
            q.append([i,j+1,1])

while q:
    y,x,cnt = q.popleft()
    if x >= W:
        continue
    if arr[y][x] == 'c':
        continue
    ans[y][x] = cnt
    q.append([y,x+1,cnt+1])

for i in ans:
    print(*i)
