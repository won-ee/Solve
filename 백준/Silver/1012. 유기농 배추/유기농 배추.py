from collections import deque

def bfs(ny,nx):
    q = deque()
    q.append((ny,nx))
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=N or dx<0 or dx>=M:
                continue
            if arr[dy][dx] == 0:
                continue
            arr[dy][dx] = 0
            q.append((dy,dx))


T = int(input())
for _ in range(T):
    N, M, K = map(int,input().split())
    arr = [[0] * M for _ in range(N)]
    diy = [0,0,1,-1]
    dix = [1,-1,0,0]
    flag = 0


    for _ in range(K):
        y, x = map(int,input().split())
        arr[y][x] = 1

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                arr[i][j] = 0
                bfs(i,j)
                flag += 1
    print(flag)
