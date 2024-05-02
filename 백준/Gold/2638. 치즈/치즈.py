from collections import deque
N, M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]

di = [(0,1),(1,0),(0,-1),(-1,0)]

cnt = 1
ans = 0
while cnt:
    ans += 1
    q=deque()
    used = [[0]*M for _ in range(N)]
    check = [[0]*M for _ in range(N)]
    q.append((0,0))
    used[0][0] = 1
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = di[i][0] + y
            dx = di[i][1] + x
            if dy<0 or dy>=N or dx<0 or dx>=M:
                continue

            if used[dy][dx] == 1:
                continue

            if arr[dy][dx] == 1:
                check[dy][dx] += 1
                continue
            used[dy][dx] = 1
            q.append((dy,dx))

    flag = 0
    for i in range(N):
        for j in range(M):
            if check[i][j] >1:
                arr[i][j] = 0
                flag += 1
    cnt = flag

print(ans-1)