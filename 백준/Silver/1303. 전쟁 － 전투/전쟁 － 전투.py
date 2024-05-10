from collections import deque

M,N = map(int,input().split())
arr = [list(input()) for _ in range(N)]
b,w = 0,0
di = [(0,1),(1,0),(-1,0),(0,-1)]
used = [[0]*M for _ in range(N)]
ans = [0,0]

for i in range(N):
    for j in range(M):
        if used[i][j] == 0:
            q =deque()
            q.append([i,j])
            cnt = 1
            while q:
                y,x = q.popleft()
                used[y][x] = 1
                for k in range(4):
                    dy = di[k][0] + y
                    dx = di[k][1] + x
                    if dy<0 or dy>=N or dx<0 or dx>=M:continue
                    if used[dy][dx] == 1 :continue
                    if arr[i][j] == arr[dy][dx]:
                        used[dy][dx] = 1
                        cnt += 1
                        q.append([dy,dx])
            if arr[i][j] == 'W':
                ans[0] += cnt*cnt
            else:
                ans[1] += cnt*cnt

print(*ans)