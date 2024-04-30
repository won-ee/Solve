from collections import deque


N,M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
di = [(0,1),(1,0),(-1,0),(0,-1)]
ans = []

cnt = 1
while cnt:
    used = [[0]*M for _ in range(N)]
    q = deque()
    q.append((0,0))
    used[0][0] = 1

    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = di[i][0] + y
            dx = di[i][1] + x
            if dy<0 or dy>=N or dx<0 or dx>=M:continue
            if used[dy][dx]:continue
            if arr[dy][dx] == 0:
                used[dy][dx] = 1
                q.append((dy,dx))
            if arr[dy][dx] == 1:
                used[dy][dx] = 2
    cnt = 0
    for i in range(N):
        for j in range(M):
            if used[i][j] == 2:
                arr[i][j] = 0
                cnt += 1
    ans.append(cnt)
ans.pop()
print(len(ans))
print(ans[-1])

